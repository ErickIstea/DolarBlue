package com.istea.ktortest.cotizacion

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.istea.ktortest.repositorio.NetworkRepositorio

@Composable
fun CotizacionPage() {
    val viewModel : CotizacionViewModel = viewModel(
        factory = CotizacionViewModel.CotizacionViewModelFactory(
            repositorio = NetworkRepositorio()
        )
    )
    CotizacionView(
        estado = viewModel.estado
    ) {
        viewModel.ejecutar(it)
    }
}