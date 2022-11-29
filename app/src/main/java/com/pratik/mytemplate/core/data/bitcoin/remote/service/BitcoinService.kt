package com.pratik.mytemplate.core.data.bitcoin.remote.service

import com.pratik.mytemplate.core.data.bitcoin.model.BitcoinDTO
import com.pratik.mytemplate.core.data.network.networkHandler.ApiResult
import retrofit2.http.GET

interface BitcoinService {
    @GET("bpi/currentprice.json")
    suspend fun getBitcoin():ApiResult<BitcoinDTO>
}