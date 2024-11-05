package com.istea.ktortest.cotizacion

import com.istea.ktortest.repositorio.CotizacionModelo

sealed class CotizacionEstado {
    data object Vacio: CotizacionEstado()
    data object Cargando: CotizacionEstado()
    data class Ok(val dolarBlue: CotizacionModelo) : CotizacionEstado()
    data object Error: CotizacionEstado()
}