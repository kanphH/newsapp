package kan.kpo.newsapp.koin

import FirebaseAuthRepositoryImpl
import kan.kpo.newsapp.auth.repository.AuthRepository
import kan.kpo.newsapp.presentation.viewmodel.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    single<AuthRepository> { FirebaseAuthRepositoryImpl() }
}

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }

}