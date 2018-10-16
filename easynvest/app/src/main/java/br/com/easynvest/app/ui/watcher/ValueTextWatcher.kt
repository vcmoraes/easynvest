package br.com.easynvest.app.ui.watcher

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import br.com.easynvest.app.util.Util

class ValueTextWatcher(@param:NonNull private val editText: EditText, private val maxValue: Int, private var value: MutableLiveData<Double>) : TextWatcher {

    private var current = ""

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(s: Editable) {
        if (s.toString() != current) {
            editText.removeTextChangedListener(this)

            val cleanString = s.toString().replace("[,.]".toRegex(), "")
            val cleanStringParsed = current.replace("[,.]".toRegex(), "")

            var parsed = if (cleanString.isBlank()) 0.0 else java.lang.Double.parseDouble(cleanString)
            var formatted = ""
            if (parsed / 100 > maxValue) {
                parsed = java.lang.Double.parseDouble(cleanStringParsed)
            }
            if (parsed > 0) {
                formatted = Util.toCurrencyValue(parsed / 100).replace("[R$]".toRegex(), "")
            }

            if (parsed > 0) {
                value.value = parsed / 100
            } else {
                value.value = null
            }

            current = formatted
            editText.setText(formatted)
            editText.setSelection(formatted.length)

            editText.addTextChangedListener(this)
        }
    }
}