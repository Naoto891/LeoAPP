package com.example.leoapp.data.tables

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.date

object mant_reciboTable : Table("mant_recibo") {
    val idReciboEstado = integer("id_recibo_estado")
    val idCasa = integer("id_casa")
    val importe = double("importe")
    val ajuste = double("ajuste")
    val idMantRecibo = integer("id_mant_recibo")
    val fechaEmision = date("fecha_emision")
    val fechaVencimiento = date("fecha_vencimiento")
    val nRecibo = varchar("n_recibo", 255)
    val periodo = varchar("periodo", 255)
    val observacion = varchar("observacion", 255)

    override val primaryKey = PrimaryKey(idReciboEstado)
}
