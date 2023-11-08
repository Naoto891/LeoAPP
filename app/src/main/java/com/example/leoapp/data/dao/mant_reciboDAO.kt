package com.example.leoapp.data.dao

import com.example.leoapp.data.model.mant_recibo
import com.example.leoapp.data.model.mant_recibo_det
import com.example.leoapp.data.tables.mant_reciboTable
import com.example.leoapp.data.tables.mant_recibo_detTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class mant_reciboDAO{

 fun getMantRecibo(): List<mant_recibo> {
     val result = mutableListOf<mant_recibo>()
     transaction {

         val query= mant_reciboTable.selectAll()
        // val query2 = mant_recibo_detTable.select(mant_recibo_detTable.idMantRecibo eq id )
         query.forEach {

             val idReciboEstado = it[mant_reciboTable.idReciboEstado]
             val idCasa = it[mant_reciboTable.idCasa]
             val importe = it[mant_reciboTable.importe]
             val ajuste = it[mant_reciboTable.ajuste]
             val idMantRecibo = it[mant_reciboTable.idMantRecibo]
             val fechaEmision = it[mant_reciboTable.fechaEmision]
             val fechaVencimiento = it[mant_reciboTable.fechaVencimiento]
             val nRecibo = it[mant_reciboTable.nRecibo]
             val periodo = it[mant_reciboTable.periodo]
             val observacion = it[mant_reciboTable.observacion]
             result.add(
                mant_recibo(
                    idMantRecibo,
                    idCasa,
                    nRecibo,
                    periodo,
                    fechaEmision,
                    fechaVencimiento,
                    importe,
                    ajuste,
                    observacion,
                    idReciboEstado
                )
             )


         }

     }

     return result
 }

}