package com.example.leoapp.data.dao

import com.example.leoapp.data.model.mant_recibo
import com.example.leoapp.data.model.mant_recibo_det
import com.example.leoapp.data.tables.mant_reciboTable
import com.example.leoapp.data.tables.mant_recibo_detTable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.Table.Dual.references
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


class mant_recibo_detDAO {

   /* fun getMantRecibo_DET(id: Int): List<Pair<mant_recibo, mant_recibo_det>> {

        val result = mutableListOf<Pair<mant_recibo, mant_recibo_det>>()

        transaction {

            val query = (mant_reciboTable innerJoin mant_recibo_detTable)
                .slice(mant_reciboTable.columns + mant_recibo_detTable.columns).select( mant_reciboTable.idMantRecibo eq id)
            query.forEach {

                val idReciboEstado = it[mant_reciboTable.idReciboEstado]
                val idCasa = it[mant_reciboTable.idCasa]
                val importe = it[mant_reciboTable.importe]
                val ajuste = it[mant_reciboTable.ajuste]
                val idMantRecibo = it[mant_reciboTable.idMantRecibo.references(mant_recibo_detTable.idMantRecibo)]
                val fechaEmision = it[mant_reciboTable.fechaEmision]
                val fechaVencimiento = it[mant_reciboTable.fechaVencimiento]
                val nRecibo = it[mant_reciboTable.nRecibo]
                val periodo = it[mant_reciboTable.periodo]
                val observacion = it[mant_reciboTable.observacion]
                val idMantReciboDet = it[mant_recibo_detTable.idMantReciboDet]
                val idGasto = it[mant_recibo_detTable.idGasto]
                val importeCasa = it[mant_recibo_detTable.importeCasa]

                val mantRecibo = mant_recibo(
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

                val mantReciboDet = mant_recibo_det(
                    idMantReciboDet,
                    idMantRecibo,
                    idGasto,
                    importeCasa
                )

                result.add(mantRecibo to mantReciboDet)
            }



        }
        return result
    }*/


    fun getMantRecibo_DET(id: Int) : List<mant_recibo_det> {
        val result = mutableListOf<mant_recibo_det>()

        transaction {
            val query2 = mant_recibo_detTable.select(mant_recibo_detTable.idMantRecibo eq id)
            query2.forEach{
                val idMantReciboDet = it[mant_recibo_detTable.idMantReciboDet]
                val idMantRecibo = it[mant_recibo_detTable.idMantRecibo]
                val idGasto = it[mant_recibo_detTable.idGasto]
                val importeCasa = it[mant_recibo_detTable.importeCasa]

                result.add(
                    mant_recibo_det(
                        idMantReciboDet,
                        idMantRecibo,
                        idGasto,
                        importeCasa)
                )
            }
        }

        return result
    }
}

