package br.com.easynvest.app.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object CalendarUtil {

    @SuppressLint("SimpleDateFormat")
    fun toStringFormat(date: Calendar, format: String): String {
        return SimpleDateFormat(format).format(date.time)
    }
}