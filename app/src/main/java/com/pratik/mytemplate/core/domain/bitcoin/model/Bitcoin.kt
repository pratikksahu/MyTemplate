package com.pratik.mytemplate.core.domain.bitcoin.model

data class Bitcoin(
    val bpi: Bpi,
) {
    data class Bpi(
        val eur: EUR,
    ) {
        data class EUR(
            val code: String,
            val description: String,
            val rate: String,
            val rate_float: Double,
            val symbol: String
        )
    }
}