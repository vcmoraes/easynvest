package br.com.easynvest.app.model

import android.os.Parcel
import android.os.Parcelable

class Simulate() : Parcelable {

    var investmentParameter: InvestmentParameter? = null
    var grossAmount: Double? = null
    var taxesAmount: Double? = null
    var netAmount: Double? = null
    var grossAmountProfit: Double? = null
    var netAmountProfit: Double? = null
    var annualGrossRateProfit: Double? = null
    var monthlyGrossRateProfit: Double? = null
    var dailyGrossRateProfit: Double? = null
    var taxesRate: Double? = null
    var rateProfit: Double? = null
    var annualNetRateProfit: Double? = null

    constructor(parcel: Parcel) : this() {
        investmentParameter = parcel.readParcelable(InvestmentParameter::class.java.classLoader)
        grossAmount = parcel.readValue(Double::class.java.classLoader) as? Double
        taxesAmount = parcel.readValue(Double::class.java.classLoader) as? Double
        netAmount = parcel.readValue(Double::class.java.classLoader) as? Double
        grossAmountProfit = parcel.readValue(Double::class.java.classLoader) as? Double
        netAmountProfit = parcel.readValue(Double::class.java.classLoader) as? Double
        annualGrossRateProfit = parcel.readValue(Double::class.java.classLoader) as? Double
        monthlyGrossRateProfit = parcel.readValue(Double::class.java.classLoader) as? Double
        dailyGrossRateProfit = parcel.readValue(Double::class.java.classLoader) as? Double
        taxesRate = parcel.readValue(Double::class.java.classLoader) as? Double
        rateProfit = parcel.readValue(Double::class.java.classLoader) as? Double
        annualNetRateProfit = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(investmentParameter, flags)
        parcel.writeValue(grossAmount)
        parcel.writeValue(taxesAmount)
        parcel.writeValue(netAmount)
        parcel.writeValue(grossAmountProfit)
        parcel.writeValue(netAmountProfit)
        parcel.writeValue(annualGrossRateProfit)
        parcel.writeValue(monthlyGrossRateProfit)
        parcel.writeValue(dailyGrossRateProfit)
        parcel.writeValue(taxesRate)
        parcel.writeValue(rateProfit)
        parcel.writeValue(annualNetRateProfit)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Simulate> {
        override fun createFromParcel(parcel: Parcel): Simulate {
            return Simulate(parcel)
        }

        override fun newArray(size: Int): Array<Simulate?> {
            return arrayOfNulls(size)
        }
    }
}