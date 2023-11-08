package com.example.leoapp.data.model

import java.time.LocalDate

data class mant_recibo(
    val idMantRecibo: Int,
    val idCasa: Int,
    val nRecibo: String,
    val periodo: String,
    val fechaEmision: LocalDate,
    val fechaVencimiento: LocalDate,
    val importe: Double,
    val ajuste: Double,
    val observacion: String,
    val idReciboEstado: Int
)
