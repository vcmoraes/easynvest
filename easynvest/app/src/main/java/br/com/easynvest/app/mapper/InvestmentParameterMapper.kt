package br.com.easynvest.app.mapper

import android.annotation.SuppressLint
import br.com.easynvest.app.model.InvestmentParameter
import br.com.easynvest.app.util.CalendarUtil
import br.com.easynvest.core.modelResponse.InvestmentParameterResponse
import java.text.SimpleDateFormat
import java.util.*

object InvestmentParameterMapper {

    @SuppressLint("SimpleDateFormat")
    fun responseToInvestmentParameter(response: InvestmentParameterResponse): InvestmentParameter {
        val investmentParameter = InvestmentParameter()
        investmentParameter.investedAmount = response.investedAmount
        investmentParameter.yearlyInterestRate = response.yearlyInterestRate
        investmentParameter.maturityTotalDays = response.maturityTotalDays
        investmentParameter.maturityBusinessDays = response.maturityBusinessDays

        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val date = sdf.parse(response.maturityDate)
        val calendar = Calendar.getInstance()
        calendar.time = date

        investmentParameter.maturityDate = CalendarUtil.toStringFormat(calendar, "dd/MM/yyyy")
        investmentParameter.rate = response.rate
        investmentParameter.isTaxFree = response.isTaxFree
        return investmentParameter
    }
}