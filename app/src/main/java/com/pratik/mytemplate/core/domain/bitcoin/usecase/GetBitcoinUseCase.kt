package com.pratik.mytemplate.core.domain.bitcoin.usecase

import com.pratik.mytemplate.core.data.bitcoin.model.BitcoinDTO
import com.pratik.mytemplate.core.data.network.networkHandler.ApiResult
import com.pratik.mytemplate.core.domain.bitcoin.repository.BitcoinRepository
import javax.inject.Inject

class GetBitcoinUseCase @Inject constructor(private val repository: BitcoinRepository) {
    suspend operator fun invoke():ApiResult<BitcoinDTO> =
        repository.getBitcoin()
}