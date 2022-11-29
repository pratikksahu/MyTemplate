package com.pratik.mytemplate.core.domain.scenario_example.usecase

import com.pratik.mytemplate.core.data.network.networkHandler.ApiResult
import com.pratik.mytemplate.core.data.scenario_example.model.SampleResponseDTO
import com.pratik.mytemplate.core.domain.scenario_example.repository.SampleRepository
import javax.inject.Inject

class GetSomethingUseCase @Inject constructor(private val repository: SampleRepository) {

    suspend operator fun invoke():ApiResult<SampleResponseDTO> =
        repository.getSomething("param")

}