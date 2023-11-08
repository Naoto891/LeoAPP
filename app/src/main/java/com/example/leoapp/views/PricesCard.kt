package com.example.leoapp.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.leoapp.data.model.mant_recibo
import com.example.leoapp.data.model.mant_recibo_det

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PriceCard(cardViewModel: CardViewModel) {

    val listaMantReciboDet: List<mant_recibo_det> by cardViewModel.listaMantReciboDet.observeAsState(initial = emptyList())

    Scaffold(
        modifier = Modifier
            .padding(start = 4.dp, end = 4.dp, bottom = 50.dp),
        containerColor = Color(0xff9AB4FF)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = listaMantReciboDet,
                itemContent = { mantReciboDet ->
                    CardItem2(mantReciboDet)
                }
            )
        }
    }
}

@Composable
fun CardItem2(mantReciboDet: mant_recibo_det) {
    Card(
        Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xff062863))
    ) {
        Row {
            Column {
                // Imprimir detalles de mant_recibo_det
                Text(text = "ID MantReciboDet: ${mantReciboDet.idMantReciboDet}")
                Text(text = "ID MantRecibo: ${mantReciboDet.idMantRecibo}")
                Text(text = "ID Gasto: ${mantReciboDet.idGasto}")
                Text(text = "Importe Casa: ${mantReciboDet.importeCasa}")
            }
        }
    }
}
