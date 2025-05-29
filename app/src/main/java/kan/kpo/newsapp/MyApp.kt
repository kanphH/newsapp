package kan.kpo.newsapp

import android.app.Application
import kan.kpo.newsapp.article.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApp)
            modules(coreModule)
        }
    }
}