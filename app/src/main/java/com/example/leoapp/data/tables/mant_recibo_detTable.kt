package com.example.leoapp.data.tables

import org.jetbrains.exposed.sql.Table

object mant_recibo_detTable : Table("mant_recibo_det") {
    val idMantReciboDet = integer("id_mant_recibo_det")
    val idMantRecibo = integer("id_mant_recibo") references mant_reciboTable.idMantRecibo
    val idGasto = integer("id_gasto")
    val importeCasa = double("importe_casa")

    override val primaryKey = PrimaryKey(idMantReciboDet)
}