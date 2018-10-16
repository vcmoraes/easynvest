package br.com.easynvest.app.listerner

import androidx.annotation.NonNull

interface ResponseViewListerner<MODEL> {

    fun success(@NonNull response: MODEL)

    fun error(@NonNull men: String)
}