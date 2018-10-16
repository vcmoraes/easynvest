package br.com.easynvest.app.ui.activity

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import br.com.easynvest.app.R
import br.com.easynvest.app.contract.HomeContract
import br.com.easynvest.app.databinding.ActivityHomeBinding
import br.com.easynvest.app.model.Simulate
import br.com.easynvest.app.presenter.HomePresenter
import br.com.easynvest.app.ui.watcher.ValueTextWatcher
import br.com.easynvest.app.util.CalendarUtil
import br.com.easynvest.app.viewModel.HomeViewModel
import java.util.*

class HomeActivity : BaseActivity(), HomeContract.HomeView {

    private val REQUEST_SIMULATE = 1

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    private var homePresenter: HomePresenter = HomePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homePresenter.view = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        setObservers()
        setLayout()
    }

    private fun setLayout() {
        binding.inputLayoutValue.editText?.addTextChangedListener(ValueTextWatcher(binding.inputLayoutValue.editText!!, Int.MAX_VALUE, homeViewModel.getValue()))
        binding.inputLayoutPercent.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().isBlank()) {
                    homeViewModel.getPercent().value = null
                } else {
                    homeViewModel.getPercent().value = java.lang.Integer.parseInt(p0.toString())
                }
            }
        })

        binding.inputLayoutDateInvestiment.editText?.setOnClickListener {
            showDialogDate()
        }

        binding.inputLayoutDateInvestiment.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                showDialogDate()
            }
        }

        binding.btnSimulate.setOnClickListener {
            showLoading(getString(R.string.simulating))
            homePresenter.getSimulate(homeViewModel.getHomeData())
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun setObservers() {
        homeViewModel.getValue().observe(this, androidx.lifecycle.Observer {
            verifyButton()
        })

        homeViewModel.getDate().observe(this, androidx.lifecycle.Observer { newDate ->
            if (newDate != null) {
                binding.etDate.setText(CalendarUtil.toStringFormat(newDate, "dd/MM/yyyy"))
            }
            verifyButton()
        })

        homeViewModel.getPercent().observe(this, androidx.lifecycle.Observer {
            verifyButton()
        })
    }

    private fun showDialogDate() {
        val calendar = homeViewModel.getDate().value ?: Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            calendar.set(year, monthOfYear, dayOfMonth)
            homeViewModel.getDate().value = calendar
            binding.inputLayoutPercent.editText?.requestFocus()
        }, year, month, day)
        datePickerDialog.datePicker.minDate = Calendar.getInstance().timeInMillis;
        datePickerDialog.show()
    }

    private fun verifyButton() {
        binding.btnSimulate.isEnabled = homeViewModel.getValue().value != null && homeViewModel.getDate().value != null && homeViewModel.getPercent().value != null
    }

    override fun onSimulate(simulate: Simulate) {
        hiddenLoading()
        val intent = Intent(this, SimulateActivity::class.java)
        intent.putExtra(Simulate::class.java.name, simulate)
        startActivityForResult(intent, REQUEST_SIMULATE)
    }

    override fun onErrorSimulate(men: String) {
        hiddenLoading()
        showDialogMessage(men)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_SIMULATE) {
            binding.inputLayoutValue.editText?.setText("")
            binding.inputLayoutPercent.editText?.setText("")
            binding.inputLayoutDateInvestiment.editText?.setText("")
            homeViewModel.clear()
            binding.inputLayoutValue.editText?.requestFocus()
        }
    }
}

