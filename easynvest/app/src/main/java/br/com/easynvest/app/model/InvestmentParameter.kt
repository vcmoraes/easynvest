package br.com.easynvest.app.model

import android.os.Parcel
import android.os.Parcelable

class InvestmentParameter() : Parcelable {

    var investedAmount: Double? = null
    var yearlyInterestRate: Double? = null
    var maturityTotalDays: String? = null
    var maturityBusinessDays: Double? = null
    var maturityDate: String? = ""
    var rate: Double? = null
    var isTaxFree: Boolean? = false

    constructor(parcel: Parcel) : this() {
        investedAmount = parcel.readValue(Double::class.java.classLoader) as? Double
        yearlyInterestRate = parcel.readValue(Double::class.java.classLoader) as? Double
        maturityTotalDays = parcel.readString()
        maturityBusinessDays = parcel.readValue(Double::class.java.classLoader) as? Double
        maturityDate = parcel.readString()
        rate = parcel.readValue(Double::class.java.classLoader) as? Double
        isTaxFree = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(investedAmount)
        parcel.writeValue(yearlyInterestRate)
        parcel.writeString(maturityTotalDays)
        parcel.writeValue(maturityBusinessDays)
        parcel.writeString(maturityDate)
        parcel.writeValue(rate)
        parcel.writeValue(isTaxFree)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<InvestmentParameter> {
        override fun createFromParcel(parcel: Parcel): InvestmentParameter {
            return InvestmentParameter(parcel)
        }

        override fun newArray(size: Int): Array<InvestmentParameter?> {
            return arrayOfNulls(size)
        }
    }
}