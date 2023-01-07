package com.alphanication.rebirth.di

import android.content.Context
import com.alphanication.rebirth.data.remote.api.QuoteApiService
import com.alphanication.rebirth.domain.repository.NetworkMonitor
import com.alphanication.rebirth.ui.app.MainActivity
import com.alphanication.rebirth.ui.utils.LiveNetworkMonitor
import com.alphanication.rebirth.ui.utils.StrategicalExceptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofitInterface(errorInterceptor: ErrorInterceptor): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(
            OkHttpClient().newBuilder().addInterceptor(errorInterceptor)
                .addNetworkInterceptor(HttpLoggingInterceptor().also {
                    it.level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
        )
        .baseUrl(QuoteApiService.BASE_URL)
        .build()

    @Provides
    @Singleton
    fun provideQuoteApi(retrofit: Retrofit): QuoteApiService =
        retrofit.create(QuoteApiService::class.java)

    @Provides
    @Singleton
    fun provideNetworkMonitor(@ApplicationContext appContext: Context): NetworkMonitor =
        LiveNetworkMonitor(appContext = appContext)

    @Provides
    @Singleton
    fun provideErrorInterceptor(networkMonitor: NetworkMonitor): ErrorInterceptor =
        ErrorInterceptor(networkMonitor = networkMonitor)
}

class ErrorInterceptor(
    private val networkMonitor: NetworkMonitor
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()

        when {
            (networkMonitor.isConnected().not()) -> MainActivity.onError(
                StrategicalExceptions.NETWORK_DISABLE
            )
        }

        return chain.proceed(request)
    }
}
