package br.com.easynvest.app.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.easynvest.app.R
import br.com.easynvest.app.databinding.ActivitySimulateBinding
import br.com.easynvest.app.model.Simulate
import br.com.easynvest.app.util.Util
import br.com.easynvest.app.viewModel.SimulateViewModel

class SimulateActivity : BaseActivity() {

    private lateinit var binding: ActivitySimulateBinding
    private lateinit var simulateViewModel: SimulateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simulate)
        simulateViewModel = ViewModelProviders.of(this).get(SimulateViewModel::class.java)
        setLayout()
        setObservers()
        simulateViewModel.getSimulate().value = intent.getParcelableExtra(Simulate::class.java.name)
    }

    private fun setLayout() {
        binding.btnRetrySimulate.setOnClickListener { this.finish() }
    }

    private fun setObservers() {
        simulateViewModel.getSimulate().observe(this, Observer { simulate ->
            if (simulate != null) {
                binding.grossAmount.text = Util.toCurrencyValue(simulate.grossAmount)
                binding.grossAmountProfit.text = String.format(getString(R.string.gross_amount_profit), Util.toCurrencyValue(simulate.grossAmountProfit))

                binding.includeInvestedAmount.findViewById<TextView>(R.id.description).text = "Valor aplicado inicialmente"
                binding.includeGrossAmount.findViewById<TextView>(R.id.description).text = "Valor bruto do investimento"
                binding.includeGrossAmountProfit.findViewById<TextView>(R.id.description).text = "Valor do rendimento"
                binding.includeTaxesRate.findViewById<TextView>(R.id.description).text = "IR sobre o investimento"
                binding.includeNetAmount.findViewById<TextView>(R.id.description).text = "Valor líquido do investimento"
                binding.includeMaturityDate.findViewById<TextView>(R.id.description).text = "Data de resgate"
                binding.includeMaturityTotalDays.findViewById<TextView>(R.id.description).text = "Dias corridos"
                binding.includeMonthlyGrossRateProfit.findViewById<TextView>(R.id.description).text = "Rendimento mensal"
                binding.includeRate.findViewById<TextView>(R.id.description).text = "Percentual do CDI do investimento"
                binding.includeYearlyInterestRate.findViewById<TextView>(R.id.description).text = "Rentabilidade anual"
                binding.includeRateProfit.findViewById<TextView>(R.id.description).text = "Rentabilidade no período"

                binding.includeInvestedAmount.findViewById<TextView>(R.id.value).text = Util.toCurrencyValue(simulate.investmentParameter?.investedAmount)
                binding.includeGrossAmount.findViewById<TextView>(R.id.value).text = Util.toCurrencyValue(simulate.grossAmount)
                binding.includeGrossAmountProfit.findViewById<TextView>(R.id.value).text = Util.toCurrencyValue(simulate.grossAmountProfit)
                binding.includeTaxesRate.findViewById<TextView>(R.id.value).text = String.format("%s(%s)", Util.toCurrencyValue(simulate.taxesAmount), Util.toPercentValue(simulate.taxesRate))
                binding.includeNetAmount.findViewById<TextView>(R.id.value).text = Util.toCurrencyValue(simulate.netAmount)
                binding.includeMaturityDate.findViewById<TextView>(R.id.value).text = simulate.investmentParameter?.maturityDate
                binding.includeMaturityTotalDays.findViewById<TextView>(R.id.value).text = (simulate.investmentParameter?.maturityTotalDays
                        ?: "0")
                binding.includeMonthlyGrossRateProfit.findViewById<TextView>(R.id.value).text = Util.toPercentValue(simulate.monthlyGrossRateProfit)
                binding.includeRate.findViewById<TextView>(R.id.value).text = Util.toPercentValue(simulate.investmentParameter?.rate)
                binding.includeYearlyInterestRate.findViewById<TextView>(R.id.value).text = Util.toPercentValue(simulate.investmentParameter?.yearlyInterestRate)
                binding.includeRateProfit.findViewById<TextView>(R.id.value).text = Util.toPercentValue(simulate.rateProfit)

                binding.container.visibility = View.VISIBLE
            } else {
                binding.container.visibility = View.GONE
            }
        })
    }
}
