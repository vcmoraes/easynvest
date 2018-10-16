package br.com.easynvest.app.mapper

import br.com.easynvest.core.modelResponse.InvestmentParameterResponse
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
open class InvestmentParameterMapperTest {

    @InjectMocks
    private lateinit var response: InvestmentParameterResponse

    @Before
    fun setUp() {
        response.investedAmount = 10.0
        response.yearlyInterestRate = 11.0
        response.maturityTotalDays = "12"
        response.maturityBusinessDays = 13.0
        response.maturityDate = "2023-03-03T00:00:00"
        response.rate = 14.0
        response.isTaxFree = true
    }

    @Test
    fun responseToInvestmentParameter() {
        val investmentParameter = InvestmentParameterMapper.responseToInvestmentParameter(response)
        Assert.assertEquals(investmentParameter.investedAmount, 10.0)
        Assert.assertEquals(investmentParameter.yearlyInterestRate, 11.0)
        Assert.assertEquals(investmentParameter.maturityTotalDays, "12")
        Assert.assertEquals(investmentParameter.maturityBusinessDays, 13.0)
        Assert.assertEquals(investmentParameter.maturityDate, "03/03/2023")
        Assert.assertEquals(investmentParameter.rate, 14.0)
        Assert.assertEquals(investmentParameter.isTaxFree, true)
    }
}