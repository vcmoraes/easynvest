package br.com.easynvest.core.modelResponse

import com.google.gson.annotations.SerializedName

class SimulateResponse {
    @SerializedName("investmentParameter")
    var investmentParameter: InvestmentParameterResponse? = null
    @SerializedName("grossAmount")
    var grossAmount: Double? = null
    @SerializedName("taxesAmount")
    var taxesAmount: Double? = null
    @SerializedName("netAmount")
    var netAmount: Double? = null
    @SerializedName("grossAmountProfit")
    var grossAmountProfit: Double? = null
    @SerializedName("netAmountProfit")
    var netAmountProfit: Double? = null
    @SerializedName("annualGrossRateProfit")
    var annualGrossRateProfit: Double? = null
    @SerializedName("monthlyGrossRateProfit")
    var monthlyGrossRateProfit: Double? = null
    @SerializedName("dailyGrossRateProfit")
    var dailyGrossRateProfit: Double? = null
    @SerializedName("taxesRate")
    var taxesRate: Double? = null
    @SerializedName("rateProfit")
    var rateProfit: Double? = null
    @SerializedName("annualNetRateProfit")
    var annualNetRateProfit: Double? = null
}