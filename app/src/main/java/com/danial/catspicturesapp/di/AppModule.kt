package com.danial.catspicturesapp.di

import com.danial.catspicturesapp.BuildConfig
import com.danial.catspicturesapp.data.remote.CatsApi
import com.danial.catspicturesapp.data.repository.CatsImageRepositoryImpl
import com.danial.catspicturesapp.domain.repository.CatsImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideCatsApi(okHttpClient: OkHttpClient): CatsApi = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(CatsApi::class.java)


    @Provides
    @Singleton
    fun provideCatsImagesRepository(catsApi: CatsApi): CatsImageRepository =
        CatsImageRepositoryImpl(catsApi)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()


}