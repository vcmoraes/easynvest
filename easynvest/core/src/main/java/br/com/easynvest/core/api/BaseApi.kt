package br.com.easynvest.core.api

import br.com.easynvest.core.listerner.ResponseServer
import br.com.easynvest.core.modelResponse.ErrorResponse
import com.google.gson.JsonSyntaxException
import io.reactivex.annotations.NonNull
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import org.json.JSONObject
import okhttp3.ResponseBody


class BaseApi<I>(@NonNull type: Class<I>) {

    val api: I = ApiClient.getClient()!!.create(type)

    fun verifyErrorDefault(e: ResponseBody?, listerner: ResponseServer<*>) {
        try {
            val errorResponse = ErrorResponse()
            errorResponse.men = JSONObject(e?.string()).getString("message")
            errorResponse.isServerError = true
            listerner.error(errorResponse)
        } catch (e: Exception) {
            val errorResponse = ErrorResponse()
            errorResponse.men = "Ops! Estamos com problemas no momento, tente novamente mais tarde ; )"
            errorResponse.isServerError = false
            errorResponse.isInternetError = true
            listerner.error(errorResponse)
        }

    }

    fun verifyErrorDefault(e: Throwable, listerner: ResponseServer<*>) {
        try {
            if (e is HttpException) {
                if (e.code() == 503 || e.code() == 500 || e.code() == 404 || e.code() == 400) {
                    val errorResponse = ErrorResponse()
                    errorResponse.men = "Ops! Estamos com problemas no momento, tente novamente mais tarde ; )"
                    errorResponse.isServerError = true
                    listerner.error(errorResponse)
                    return
                }
            } else if (e is SocketTimeoutException || e is ConnectException || e is JsonSyntaxException) {
                val errorResponse = ErrorResponse()
                errorResponse.men = "Ops! Estamos com problemas no momento, tente novamente mais tarde ; )"
                errorResponse.isServerError = true
                listerner.error(errorResponse)
                return
            }
            val errorResponse = ErrorResponse()
            errorResponse.men = "Verifique sua conexão e tente novamente"
            errorResponse.isServerError = false
            errorResponse.isInternetError = true
            listerner.error(errorResponse)
        } catch (ee: Exception) {
            try {
                val errorResponse = ErrorResponse()
                errorResponse.isServerError = true
                listerner.error(errorResponse)
            } catch (ignore: Exception) {
                e.printStackTrace()
            }

        }

    }
}