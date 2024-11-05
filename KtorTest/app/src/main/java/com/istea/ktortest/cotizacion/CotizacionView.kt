package com.istea.ktortest.cotizacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.istea.ktortest.repositorio.CotizacionModelo

@Composable
fun CotizacionView(
    modifier: Modifier = Modifier,
    estado: CotizacionEstado,
    ejecutar: (CotizacionIntencion) -> Unit
) {

    Scaffold {
        Column(
            modifier = modifier.padding(it)
        ) {
            when(estado){
                is CotizacionEstado.Cargando -> Cargando()
                is CotizacionEstado.Error -> Error()
                is CotizacionEstado.Ok -> Cotizacion(estado.dolarBlue)
                is CotizacionEstado.Vacio -> Text("Vacio")
            }
            Text("este es un texto al pedo")
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    ejecutar(CotizacionIntencion.cargarCotizacion)
                }
            ) {
                Text("Refrescar")
            }
        }
    }
}
@Composable
fun Cargando(){
    Text("Cargando...")
}

@Composable
fun Error(){
    Text("Se rompio todo")
}

@Composable
fun Cotizacion(dolarBlue: CotizacionModelo) {
    Column {
        Text(
            "Cotizacion: ${dolarBlue.value_avg}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            "Compra: ${dolarBlue.value_buy}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            "Venta: ${dolarBlue.value_sell}",
            style = MaterialTheme.typography.titleLarge
        )
    }

}