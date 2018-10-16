package br.com.easynvest.core.api.simulate

import br.com.easynvest.core.modelResponse.SimulateResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimulateRetrofit {

    @GET("/calculator/simulate")
    fun getSimulate(@Query("investedAmount") investedAmount: Double,
                    @Query("index") index: String,
                    @Query("rate") rate: Int,
                    @Query("isTaxFree") isTaxFree: Boolean,
                    @Query("maturityDate") maturityDate: String): Observable<Response<SimulateResponse>>
}