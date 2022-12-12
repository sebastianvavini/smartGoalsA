package com.codecomponents.smartgoalsa.constants

class Constants private constructor(){

    object TABLE {
        const val TABLE_NAME_USER="user"
        const val TABLE_NAME_META="meta"
    }
    object COLUMNS_USER{
        //(user:String, password:String,whatsapp:String)
        const val ID="id"
        const val CPF="cpf"
        const val USER="user"
        const val PASSWORD="password"
        const val WHATSAPP="whats"

    }
    object COLUMNS_META{

        const val ID="id"
        const val descricao="descricao"

        const val expectativa="expectativa"
        const val importancia="importancia"
        const val envolvidos = "envolvidos"
        const val  recursos="recursos"

        const val quantitativos_eperados="quantitativos_esperados"
        const val ponto_de_alcance="ponto_de_alcance"
        const val metricas_acompanhamento="metricas_acompanhamento"

        const val responsaveis ="responsaveis"

        const val tem_orcamento="tem_orcamento"
        const val tenho_recursos="tenho_recursos"

        const val data_final="data_final"
        const val o_que_pode_ser_alcancado="o_que_pode_ser_alcancado"





    }

}