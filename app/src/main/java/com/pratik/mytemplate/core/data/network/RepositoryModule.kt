package com.pratik.mytemplate.core.data.network

import com.pratik.mytemplate.core.data.bitcoin.remote.service.BitcoinService
import com.pratik.mytemplate.core.data.bitcoin.repository.BitcoinRepositoryImpl
import com.pratik.mytemplate.core.data.scenario_example.remote.service.SampleService
import com.pratik.mytemplate.core.data.scenario_example.repository.SampleRepositoryImpl
import com.pratik.mytemplate.core.domain.bitcoin.repository.BitcoinRepository
import com.pratik.mytemplate.core.domain.scenario_example.repository.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    //Provide Service
    @Singleton
    @Provides
    fun provideSampleService(retrofit: Retrofit): SampleService {
        return retrofit.create(SampleService::class.java)
    }

    //Provide repository
    @Singleton
    @Provides
    fun provideSampleRepository(sampleService: SampleService): SampleRepository {
        return SampleRepositoryImpl(sampleService)
    }

    //Provide Service
    @Singleton
    @Provides
    fun provideBitcoinService(retrofit: Retrofit): BitcoinService {
        return retrofit.create(BitcoinService::class.java)
    }

    //Provide repository
    @Singleton
    @Provides
    fun provideBitcoinRepository(bitcoinService: BitcoinService): BitcoinRepository {
        return BitcoinRepositoryImpl(bitcoinService)
    }

}