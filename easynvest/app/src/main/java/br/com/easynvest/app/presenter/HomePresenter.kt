package br.com.easynvest.app.presenter

import br.com.easynvest.app.contract.HomeContract
import br.com.easynvest.app.listerner.ResponseViewListerner
import br.com.easynvest.app.model.HomeData
import br.com.easynvest.app.model.Simulate
import br.com.easynvest.app.usecase.simulate.SimulateUseCase

class HomePresenter : Presenter<HomeContract.HomeView>(), HomeContract.HomePresenter {

    override fun getSimulate(homeData: HomeData) {
        SimulateUseCase.getSimulate(homeData, object : ResponseViewListerner<Simulate> {
            override fun success(response: Simulate) {
                view?.onSimulate(response)
            }

            override fun error(men: String) {
                view?.onErrorSimulate(men)
            }
        })
    }
}