package br.com.easynvest.app.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.easynvest.app.model.Simulate

class SimulateViewModel : ViewModel() {

    private val simulate = MutableLiveData<Simulate>()

    fun getSimulate(): MutableLiveData<Simulate> {
        return simulate
    }

}