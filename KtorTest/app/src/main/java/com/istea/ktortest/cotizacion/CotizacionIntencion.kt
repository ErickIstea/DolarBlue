package com.istea.ktortest.cotizacion

sealed class CotizacionIntencion {
    data object cargarCotizacion: CotizacionIntencion()
}