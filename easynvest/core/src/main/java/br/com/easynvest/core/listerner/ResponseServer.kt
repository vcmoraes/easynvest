package br.com.easynvest.core.listerner

import br.com.easynvest.core.modelResponse.ErrorResponse

interface ResponseServer<MODEL> {

    fun success(response: MODEL)

    fun error(errorResponse: ErrorResponse)
}