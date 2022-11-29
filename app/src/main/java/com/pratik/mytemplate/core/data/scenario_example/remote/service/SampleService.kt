package com.pratik.mytemplate.core.data.scenario_example.remote.service

import com.pratik.mytemplate.core.data.network.networkHandler.ApiResult
import com.pratik.mytemplate.core.data.scenario_example.model.SampleResponseDTO
import retrofit2.http.GET

interface SampleService {

    @GET
    suspend fun getSomething() : ApiResult<SampleResponseDTO>
}