package br.com.easynvest.app.contract

import androidx.annotation.NonNull
import br.com.easynvest.app.model.HomeData
import br.com.easynvest.app.model.Simulate

class HomeContract {

    interface HomeView {
        fun onSimulate(@NonNull simulate: Simulate)
        fun onErrorSimulate(@NonNull men : String)
    }

    interface HomePresenter {
        fun getSimulate(homeData: HomeData)
    }
}