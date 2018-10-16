package br.com.easynvest.app.util

import java.text.NumberFormat
import java.util.*

object Util {

    fun toCurrencyValue(value: Double?): String {
        val numberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
        return numberFormat.format(value ?: 0.0).replace("R$", "R$ ")
    }

    fun toPercentValue(value: Double?): String {
        return String.format("%.2f%%", value ?: 0.0).replace(",00", "")
    }
}