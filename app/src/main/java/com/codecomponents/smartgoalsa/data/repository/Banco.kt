package com.codecomponents.smartgoalsa.data.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.codecomponents.smartgoalsa.constants.Constants
import com.codecomponents.smartgoalsa.constants.Constants.COLUMNS_META.quantitativos_eperados

class Banco  (context: Context) :
    SQLiteOpenHelper(context, NAME, null, VERSION){

    companion object {
        private const val NAME= "smartGoalsDB"
        private const val VERSION=1


    }

    override fun onCreate(db: SQLiteDatabase) {

       /** val tabela= Constants.TABLE.TABLE_NAME_USER

            val id= Constants.COLUMNS_USER.ID
            val username=Constants.COLUMNS_USER.USER
            val cpf= Constants.COLUMNS_USER.CPF
            val whats=Constants.COLUMNS_USER.WHATSAPP
            val password=Constants.COLUMNS_USER.PASSWORD


        db.execSQL("create table $tabela ("+
                "$id integer primary key autoincrement,"+
                "$username text,"+ "$cpf text,"+ "$password text,"+"$whats text"+
                ")")

**/

        val tabela_meta = Constants.TABLE.TABLE_NAME_META

            val id_meta= Constants.COLUMNS_META.ID
             val descrisao_meta=Constants.COLUMNS_META.descricao
             val expectativa= Constants.COLUMNS_META.expectativa
            val importancia=Constants.COLUMNS_META.importancia
            val envolvidos=Constants.COLUMNS_META.envolvidos
            val recursos=Constants.COLUMNS_META.recursos
            val quantitativos_eperados= Constants.COLUMNS_META.quantitativos_eperados
            val ponto_alcance=Constants.COLUMNS_META.ponto_de_alcance
            val metricas_acompanhamento= Constants.COLUMNS_META.metricas_acompanhamento
            val responsaveis= Constants.COLUMNS_META.responsaveis
            val tem_orcamento=Constants.COLUMNS_META.tem_orcamento
            val tenho_recursos=Constants.COLUMNS_META.tenho_recursos
             val data_final=Constants.COLUMNS_META.data_final
            val o_que_pode_ser_alcancado=Constants.COLUMNS_META.o_que_pode_ser_alcancado




        db.execSQL("create table $tabela_meta ("+
                "$id_meta integer primary key autoincrement,"+
                "$descrisao_meta text,"+ "$expectativa text,"+ "$importancia text,"+
                "$envolvidos text,"+ "$recursos text,"+ "$quantitativos_eperados text,"+
                "$ponto_alcance text,"+ "$metricas_acompanhamento text,"+"$responsaveis text,"+
                "$tem_orcamento text,"+"$tenho_recursos text,"+"$data_final text,"+
                "$data_final text,"+ "$o_que_pode_ser_alcancado text"+
                ")")

    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}