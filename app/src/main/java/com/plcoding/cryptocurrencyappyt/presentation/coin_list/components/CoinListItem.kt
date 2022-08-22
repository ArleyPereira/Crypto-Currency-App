package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {

    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 20.dp),
        elevation = 5.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(coin) }
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                color = Color.Black,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = if (coin.isSctive) "active" else "inactive",
                color = if (coin.isSctive) Color.Green else Color.Red,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.body2
            )
        }

    }

}