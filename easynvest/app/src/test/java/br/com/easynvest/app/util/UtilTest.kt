package br.com.easynvest.app.util

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
open class UtilTest {

    @Test
    fun toCurrencyValue() {
        Assert.assertEquals(Util.toCurrencyValue(12.0), "R$  12,00")
        Assert.assertEquals(Util.toCurrencyValue(12.78), "R$  12,78")
    }

    @Test
    fun toPercentValue() {
        Assert.assertEquals(Util.toPercentValue(12.0), "12%")
        Assert.assertEquals(Util.toPercentValue(12.78), "12,78%")
    }
}