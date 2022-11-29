package com.pratik.mytemplate.core.data.bitcoin.repository

import com.pratik.mytemplate.core.data.bitcoin.model.BitcoinDTO
import com.pratik.mytemplate.core.data.bitcoin.remote.service.BitcoinService
import com.pratik.mytemplate.core.data.network.networkHandler.ApiResult
import com.pratik.mytemplate.core.domain.bitcoin.repository.BitcoinRepository
import javax.inject.Inject

class BitcoinRepositoryImpl @Inject constructor(private val bitcoinService: BitcoinService):
    BitcoinRepository {
    override suspend fun getBitcoin(): ApiResult<BitcoinDTO> =
        bitcoinService.getBitcoin()
}