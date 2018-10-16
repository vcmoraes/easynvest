package br.com.easynvest.app.mapper

import br.com.easynvest.core.modelResponse.InvestmentParameterResponse
import br.com.easynvest.core.modelResponse.SimulateResponse
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
open class SimulateMapperTest {

    @InjectMocks
    private lateinit var response: SimulateResponse

    @InjectMocks
    private lateinit var investmentParameterResponse: InvestmentParameterResponse

    @Before
    fun setUp() {
        response.investmentParameter = null
        response.grossAmount = 10.0
        response.taxesAmount = 11.0
        response.netAmount = 12.0
        response.grossAmountProfit = 13.0
        response.netAmountProfit = 14.0
        response.annualGrossRateProfit = 15.0
        response.monthlyGrossRateProfit = 16.0
        response.dailyGrossRateProfit = 17.0
        response.taxesRate = 18.0
        response.rateProfit = 19.0
        response.annualNetRateProfit = 20.0

        investmentParameterResponse.investedAmount = 10.0
        investmentParameterResponse.yearlyInterestRate = 11.0
        investmentParameterResponse.maturityTotalDays = "12"
        investmentParameterResponse.maturityBusinessDays = 13.0
        investmentParameterResponse.maturityDate = "2023-03-03T00:00:00"
        investmentParameterResponse.rate = 14.0
        investmentParameterResponse.isTaxFree = true

        response.investmentParameter = investmentParameterResponse
    }

    @Test
    fun responseToSimulate() {
        val simulateResponse = SimulateMapper.responseToSimulate(response)
        Assert.assertEquals(simulateResponse.grossAmount, 10.0)
        Assert.assertEquals(simulateResponse.taxesAmount, 11.0)
        Assert.assertEquals(simulateResponse.netAmount, 12.0)
        Assert.assertEquals(simulateResponse.grossAmountProfit, 13.0)
        Assert.assertEquals(simulateResponse.netAmountProfit, 14.0)
        Assert.assertEquals(simulateResponse.annualGrossRateProfit, 15.0)
        Assert.assertEquals(simulateResponse.monthlyGrossRateProfit, 16.0)
        Assert.assertEquals(simulateResponse.dailyGrossRateProfit, 17.0)
        Assert.assertEquals(simulateResponse.taxesRate, 18.0)
        Assert.assertEquals(simulateResponse.rateProfit, 19.0)
        Assert.assertEquals(simulateResponse.annualNetRateProfit, 20.0)
        Assert.assertNotNull(simulateResponse.investmentParameter)
    }
}