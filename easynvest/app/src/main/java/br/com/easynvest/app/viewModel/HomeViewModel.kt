package br.com.easynvest.app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.easynvest.app.model.HomeData
import java.util.*

class HomeViewModel : ViewModel() {

    private val value = MutableLiveData<Double>()
    private val date = MutableLiveData<Calendar>()
    private val percent = MutableLiveData<Int>()

    fun getValue(): MutableLiveData<Double> {
        return value
    }

    fun getDate(): MutableLiveData<Calendar> {
        return date
    }

    fun getPercent(): MutableLiveData<Int> {
        return percent
    }

    fun getHomeData(): HomeData {
        val homeData = HomeData()
        homeData.value = value.value ?: 0.0
        homeData.date = date.value ?: Calendar.getInstance()
        homeData.percent = percent.value ?: 0
        return homeData
    }

    fun clear() {
        value.value = null
        date.value = null
        percent.value = null
    }
}