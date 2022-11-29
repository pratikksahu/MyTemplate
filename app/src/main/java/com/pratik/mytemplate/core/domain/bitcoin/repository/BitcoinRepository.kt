package com.pratik.mytemplate.core.domain.bitcoin.repository

import com.pratik.mytemplate.core.data.bitcoin.model.BitcoinDTO
import com.pratik.mytemplate.core.data.network.networkHandler.ApiResult

interface BitcoinRepository {
    suspend fun getBitcoin(): ApiResult<BitcoinDTO>
}