package br.com.easynvest.app.util

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.text.SimpleDateFormat
import java.util.*

@RunWith(MockitoJUnitRunner::class)
open class CalendarUtilTest {

    @Test
    fun toStringFormat() {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val date = sdf.parse("2050-08-14T12:00:00")
        val calendar = Calendar.getInstance()
        calendar.time = date
        Assert.assertEquals(CalendarUtil.toStringFormat(calendar, "dd/MM/yyyy"), "14/08/2050")
        Assert.assertEquals(CalendarUtil.toStringFormat(calendar, "yyyy-MM-dd"), "2050-08-14")
    }
}