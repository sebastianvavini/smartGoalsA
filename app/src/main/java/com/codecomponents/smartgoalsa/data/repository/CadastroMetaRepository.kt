package com.codecomponents.smartgoalsa.data.repository

import android.content.ContentValues
import android.content.Context
import com.codecomponents.smartgoalsa.constants.Constants
import com.codecomponents.smartgoalsa.data.model.MetaModel

class CadastroMetaRepository  private constructor(context: Context){
    private val database= Banco(context)

    companion object{
        private lateinit var repository: CadastroMetaRepository

        fun getInstance(context: Context): CadastroMetaRepository {
            if(!Companion::repository.isInitialized){
                repository = CadastroMetaRepository(context)
            }
            return repository
        }
    }

    fun insert(meta: MetaModel):Boolean{

        try {
            val db = database.writableDatabase

            val tabela= Constants.TABLE.TABLE_NAME_META

            val metaId=Constants.COLUMNS_META.ID
            val metaDescricao=Constants.COLUMNS_META.descricao


            val values= ContentValues()

            values.put(metaId,meta.id)
            values.put(metaDescricao,meta.descricao)

            db.insert(tabela,null,values)
            println("Chamou insert")

            return true
        }
        catch (e:Exception){
            println()
            return false
        }
    }

}