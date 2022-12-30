package com.codecomponents.smartgoalsa.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codecomponents.smartgoalsa.data.model.MetaModel
import com.codecomponents.smartgoalsa.data.repository.CadastroMetaRepository

class CadastroMetaViewModel (application: Application): AndroidViewModel(application){

    private var repository = CadastroMetaRepository.getInstance(application)

    private var salvou_ = MutableLiveData<Boolean>()
    var salvou: LiveData<Boolean> = salvou_


    fun insert(metaModel: MetaModel){
        salvou_.value = repository.insert(metaModel)
    }
}