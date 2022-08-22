package com.plcoding.cryptocurrencyappyt.domain.model

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto

data class Coin(
    val id: String,
    val isSctive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isSctive = isSctive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}