package com.example.composequotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composequotesapp.modal.Quote

@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Card(elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(quote) }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription = "Quote",
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180f)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = quote.quote,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                    style = MaterialTheme.typography.body2
                )
                Box(
                    modifier = Modifier
                        .background(Color(0xFFEEEEEE))
                        .height(1.dp)
                        .fillMaxWidth(.4f)
                )

                Text(
                    text = quote.author, modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Thin
                )
            }
        }

    }
}

