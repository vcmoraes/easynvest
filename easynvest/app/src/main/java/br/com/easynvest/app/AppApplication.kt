package br.com.easynvest.app

import android.app.Application
import br.com.easynvest.core.api.InitCore

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InitCore.init()
    }
}