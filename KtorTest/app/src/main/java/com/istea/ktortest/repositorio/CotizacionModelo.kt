package com.istea.ktortest.repositorio

import kotlinx.serialization.Serializable

@Serializable
data class CotizacionModelo(
    var value_avg: Float,
    var value_sell: Float,
    var value_buy: Float
)

@Serializable
data class RespuestaCotizacionesModelo(
    var oficial: CotizacionModelo,
    var blue: CotizacionModelo,
    var oficial_euro: CotizacionModelo,
    var blue_euro: CotizacionModelo
)