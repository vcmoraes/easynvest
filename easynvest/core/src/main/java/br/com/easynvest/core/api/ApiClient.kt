package br.com.easynvest.core.api

import br.com.easynvest.core.exceptions.URLException
import io.reactivex.annotations.NonNull
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private var clientBuilder: OkHttpClient.Builder? = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)

    private var client: Retrofit? = null

    init {
        clientBuilder = OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
    }

    fun getClient(): Retrofit? {
        if (client == null) {
            throw URLException()
        }
        return client
    }

    fun setEndPoint(@NonNull endPoint: String, @NonNull interceptor: Interceptor) {
        clientBuilder!!.addInterceptor(interceptor)
        setEndPoint(endPoint)
    }

    fun setEndPoint(@NonNull endPoint: String) {
        client = Retrofit.Builder()
                .baseUrl(endPoint)
                .client(clientBuilder!!.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}