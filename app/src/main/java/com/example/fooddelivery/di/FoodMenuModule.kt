package com.example.fooddelivery.di

import com.example.fooddelivery.BuildConfig
import com.example.fooddelivery.domain.FoodMenuUseCaseImpl
import com.example.fooddelivery.network.FoodMenuApi
import com.example.fooddelivery.ui.FoodMenuUseCase
import com.example.fooddelivery.utils.UnsafeOkHttpClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
abstract class FoodMenuModule {

    @Binds
    abstract fun bindUseCase(
        useCaseImpl: FoodMenuUseCaseImpl
    ): FoodMenuUseCase
}

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideApi() = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(UnsafeOkHttpClient.getUnsafeOkHttpClient())
        .build()

    @Provides
    @Singleton
    fun provideApiService() = provideApi().create(FoodMenuApi::class.java)
}



