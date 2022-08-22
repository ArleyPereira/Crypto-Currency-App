package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.model.toCoin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())

            val coins = repository.getCoinById(coinId).toCoinDetail()

            emit(Resource.Success<CoinDetail>(coins))

        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Ocorreu um erro inesperado."))
        } catch (e: IOException) {
            emit(
                Resource.Error<CoinDetail>(
                    e.localizedMessage
                        ?: "Não foi possível acessar o servidor, Verifique sua internet."
                )
            )
        }
    }

}