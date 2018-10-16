package br.com.easynvest.core.api.simulate

import androidx.annotation.NonNull
import br.com.easynvest.core.api.BaseApi
import br.com.easynvest.core.listerner.ResponseServer
import br.com.easynvest.core.modelResponse.SimulateResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

object SimulateApi {

    private val simulateApi = BaseApi(SimulateRetrofit::class.java)

    fun simulate(@NonNull investedAmount: Double,
                 @NonNull index: String,
                 @NonNull rate: Int,
                 @NonNull isTaxFree: Boolean,
                 @NonNull maturityDate: String,
                 @NonNull listerner: ResponseServer<SimulateResponse>) {
        simulateApi.api.getSimulate(investedAmount, index, rate, isTaxFree, maturityDate).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(object : Observer<Response<SimulateResponse>> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(response: Response<SimulateResponse>) {
                if (response.errorBody() != null) {
                    simulateApi.verifyErrorDefault(response.errorBody(), listerner)
                } else {
                    listerner.success(response.body()!!)
                }
            }

            override fun onError(e: Throwable) {
                simulateApi.verifyErrorDefault(e, listerner)
            }

            override fun onComplete() {

            }
        })
    }
}