package br.com.easynvest.core.modelResponse

import com.google.gson.annotations.SerializedName

class InvestmentParameterResponse {
    @SerializedName("investedAmount")
    var investedAmount: Double? = null
    @SerializedName("yearlyInterestRate")
    var yearlyInterestRate: Double? = null
    @SerializedName("maturityTotalDays")
    var maturityTotalDays: String? = null
    @SerializedName("maturityBusinessDays")
    var maturityBusinessDays: Double? = null
    @SerializedName("maturityDate")
    var maturityDate: String? = null
    @SerializedName("rate")
    var rate: Double? = null
    @SerializedName("isTaxFree")
    var isTaxFree: Boolean = false
}