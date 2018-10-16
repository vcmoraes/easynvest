package br.com.easynvest.app.mapper

import br.com.easynvest.app.model.Simulate
import br.com.easynvest.core.modelResponse.InvestmentParameterResponse
import br.com.easynvest.core.modelResponse.SimulateResponse

object SimulateMapper {

    fun responseToSimulate(response: SimulateResponse): Simulate {
        val simulate = Simulate()
        simulate.investmentParameter = InvestmentParameterMapper.responseToInvestmentParameter(response.investmentParameter
                ?: InvestmentParameterResponse())
        simulate.grossAmount = response.grossAmount
        simulate.taxesAmount = response.taxesAmount
        simulate.netAmount = response.netAmount
        simulate.grossAmountProfit = response.grossAmountProfit
        simulate.netAmountProfit = response.netAmountProfit
        simulate.annualGrossRateProfit = response.annualGrossRateProfit
        simulate.monthlyGrossRateProfit = response.monthlyGrossRateProfit
        simulate.dailyGrossRateProfit = response.dailyGrossRateProfit
        simulate.taxesRate = response.taxesRate
        simulate.rateProfit = response.rateProfit
        simulate.annualNetRateProfit = response.annualNetRateProfit
        return simulate
    }
}