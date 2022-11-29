package com.pratik.mytemplate.core.data.network

import com.pratik.mytemplate.core.data.network.networkHandler.BasicAuthInterceptor
import com.pratik.mytemplate.core.data.network.networkHandler.ResultCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val username = APIKEYS.USERNAME
    private const val password = APIKEYS.PASSWORD
    private const val BASE_URL = APIKEYS.BASE_URL

    @Singleton
    @Provides
    fun getInstance(client:OkHttpClient) : Retrofit{

        return Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory.create())
            .build()
    }
    @Provides
    fun provideClient():OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(BasicAuthInterceptor(username, password))
            .addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
            .build()




    //Template for room database

//    @Provides
//    @Singleton
//    fun provideDatabase(@ApplicationContext context: Context): SmsSentDatabase{
//        return Room.databaseBuilder(context,
//            SmsSentDatabase::class.java,
//            "SmsSentDatabase").build()
//    }
//    @Provides
//    fun provideSmsSentDAO(smsSentDatabase: SmsSentDatabase) : SmsSentDAO{
//        return smsSentDatabase.smsSentDAO()
//    }

}

