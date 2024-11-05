package com.istea.ktortest.repositorio

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NetworkRepositorio : Repositorio {

    private val cliente = HttpClient(){
        install(ContentNegotiation){
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }

    override suspend fun getDolarBlue(): CotizacionModelo {
        val respuesta = cliente.get("https://api.blusadasdasdelytics.com.ar/v2/latest"){
            parameter("nombre","valor")
            parameter("nombre","valor")
            parameter("nombre","valor")
            parameter("nombre","valor")
        }
        if (respuesta.status == HttpStatusCode.OK){
            val body = respuesta.body<RespuestaCotizacionesModelo>()
            return body.blue
        }else{
            throw Exception()
        }
    }

//    https://api.bluelytics.com.ar/v2/latest
}