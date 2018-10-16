package br.com.easynvest.core.api

object InitCore {

    fun init() {
        ApiClient.setEndPoint("https://api-simulator-calc.easynvest.com.br")
    }
}