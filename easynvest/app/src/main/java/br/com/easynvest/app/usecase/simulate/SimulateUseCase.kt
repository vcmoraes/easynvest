package br.com.easynvest.app.usecase.simulate

import br.com.easynvest.app.listerner.ResponseViewListerner
import br.com.easynvest.app.mapper.SimulateMapper
import br.com.easynvest.app.model.HomeData
import br.com.easynvest.app.model.Simulate
import br.com.easynvest.app.util.CalendarUtil
import br.com.easynvest.core.api.simulate.SimulateApi
import br.com.easynvest.core.listerner.ResponseServer
import br.com.easynvest.core.modelResponse.ErrorResponse
import br.com.easynvest.core.modelResponse.SimulateResponse

object SimulateUseCase {

    fun getSimulate(homeData: HomeData, listerner: ResponseViewListerner<Simulate>) {
        SimulateApi.simulate(homeData.value, "CDI", homeData.percent, false, CalendarUtil.toStringFormat(homeData.date, "yyyy-MM-dd"), object : ResponseServer<SimulateResponse> {
            override fun success(response: SimulateResponse) {
                listerner.success(SimulateMapper.responseToSimulate(response))
            }

            override fun error(errorResponse: ErrorResponse) {
                listerner.error(errorResponse.men ?: "")
            }

        })
    }
}