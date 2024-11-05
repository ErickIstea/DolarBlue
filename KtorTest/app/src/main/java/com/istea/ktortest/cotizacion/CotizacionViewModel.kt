package com.istea.ktortest.cotizacion

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.istea.ktortest.repositorio.Repositorio
import kotlinx.coroutines.launch

class CotizacionViewModel(
    val repositorio: Repositorio
): ViewModel() {

    var estado by mutableStateOf<CotizacionEstado>(CotizacionEstado.Vacio)

    fun ejecutar (intencion: CotizacionIntencion) {
        when(intencion){
            CotizacionIntencion.cargarCotizacion -> cargarCotizacion()
        }
    }

    private fun cargarCotizacion() {
        estado = CotizacionEstado.Cargando
        viewModelScope.launch {
            try {
                val dolarBlue = repositorio.getDolarBlue()
                estado = CotizacionEstado.Ok(dolarBlue)
            } catch (exeption:Exception) {
                estado = CotizacionEstado.Error
            }

        }
    }

    class CotizacionViewModelFactory(
        private val repositorio: Repositorio,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CotizacionViewModel::class.java)) {
                return CotizacionViewModel(repositorio) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}