package br.com.easynvest.app.ui.activity

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Build
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.easynvest.app.R

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = ContextCompat.getColor(this, R.color.colorAccent)
        }
    }

    fun showLoading(@NonNull men: String) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this, "", men)
        }
    }

    fun hiddenLoading() {
        if (progressDialog != null && progressDialog!!.isShowing && !isFinishing()) {
            progressDialog!!.dismiss()
            progressDialog = null
        }
    }

    fun showDialogMessage(men: String, onClickListener: DialogInterface.OnClickListener? = null) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("")
                .setMessage(men)
                .setPositiveButton(android.R.string.ok, onClickListener)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
    }
}