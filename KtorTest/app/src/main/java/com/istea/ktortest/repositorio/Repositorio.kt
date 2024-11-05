package com.istea.ktortest.repositorio

interface Repositorio {
    suspend fun getDolarBlue() : CotizacionModelo
}