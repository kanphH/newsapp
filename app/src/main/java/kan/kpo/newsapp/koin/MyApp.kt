package kan.kpo.newsapp.koin

import android.app.Application
import com.google.firebase.FirebaseApp
import kan.kpo.newsapp.article.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
        startKoin{
            androidContext(this@MyApp)
            modules(coreModule)
        }
    }
}