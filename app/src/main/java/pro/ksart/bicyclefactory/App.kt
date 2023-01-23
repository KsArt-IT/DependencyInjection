package pro.ksart.bicyclefactory

import android.app.Application
import android.content.Context
import org.koin.core.context.startKoin
import pro.ksart.bicyclefactory.dagger.AppComponent
import pro.ksart.bicyclefactory.dagger.DaggerAppComponent
import pro.ksart.bicyclefactory.koin.bicycleModule
import pro.ksart.bicyclefactory.koin.otherModule

class App : Application() {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
        get() = checkNotNull(_appComponent) {
            "AppComponent isn't initialized"
        }

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerAppComponent.builder().build()

        startKoin {
            modules(listOf(otherModule, bicycleModule))
        }
    }

}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }
