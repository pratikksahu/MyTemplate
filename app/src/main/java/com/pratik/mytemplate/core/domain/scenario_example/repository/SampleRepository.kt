package com.pratik.mytemplate.core.domain.scenario_example.repository

import com.pratik.mytemplate.core.data.network.networkHandler.ApiResult
import com.pratik.mytemplate.core.data.scenario_example.model.SampleResponseDTO

interface SampleRepository {
    suspend fun getSomething(param:String):ApiResult<SampleResponseDTO>
}