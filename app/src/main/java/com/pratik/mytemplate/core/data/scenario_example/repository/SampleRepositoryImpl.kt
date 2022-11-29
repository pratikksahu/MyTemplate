package com.pratik.mytemplate.core.data.scenario_example.repository

import com.pratik.mytemplate.core.data.network.networkHandler.ApiResult
import com.pratik.mytemplate.core.data.scenario_example.model.SampleResponseDTO
import com.pratik.mytemplate.core.data.scenario_example.remote.service.SampleService
import com.pratik.mytemplate.core.domain.scenario_example.repository.SampleRepository
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(private val sampleService: SampleService):SampleRepository {
    override suspend fun getSomething(param: String): ApiResult<SampleResponseDTO> =
        sampleService.getSomething()
}