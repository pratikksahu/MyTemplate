package com.pratik.mytemplate.core.data.bitcoin.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.pratik.mytemplate.core.domain.bitcoin.model.Bitcoin

@Keep
@Parcelize
data class BitcoinDTO(
    val bpi: Bpi,
    val chartName: String,
    val disclaimer: String,
    val time: Time
) : Parcelable {
    @Keep
    @Parcelize
    data class Bpi(
        @SerializedName("EUR")
        val eur: EUR,
        @SerializedName("GBP")
        val gbp: GBP,
        @SerializedName("USD")
        val usd: USD
    ) : Parcelable {
        @Keep
        @Parcelize
        data class EUR(
            val code: String,
            val description: String,
            val rate: String,
            val rate_float: Double,
            val symbol: String
        ) : Parcelable

        @Keep
        @Parcelize
        data class GBP(
            val code: String,
            val description: String,
            val rate: String,
            val rate_float: Double,
            val symbol: String
        ) : Parcelable

        @Keep
        @Parcelize
        data class USD(
            val code: String,
            val description: String,
            val rate: String,
            val rate_float: Double,
            val symbol: String
        ) : Parcelable
    }

    @Keep
    @Parcelize
    data class Time(
        val updated: String,
        val updatedISO: String,
        val updateduk: String
    ) : Parcelable
}

fun BitcoinDTO.convert() : Bitcoin =
    Bitcoin(bpi = Bitcoin.Bpi(Bitcoin.Bpi.EUR(
        this.bpi.eur.code,
        this.bpi.eur.description,
        this.bpi.eur.rate,
        this.bpi.eur.rate_float,
        this.bpi.eur.symbol)),)