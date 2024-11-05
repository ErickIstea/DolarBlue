package com.istea.ktortest.repositorio

import kotlinx.coroutines.delay

class MockRepositorio : Repositorio {
    override suspend fun getDolarBlue(): CotizacionModelo {
        delay(2000)
        return CotizacionModelo(
            1000f,
            1200f,
            1233f
        )
    }
}