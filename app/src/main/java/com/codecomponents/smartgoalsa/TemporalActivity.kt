package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codecomponents.smartgoalsa.databinding.ActivityTemporalBinding
import com.codecomponents.smartgoalsa.shared.SharedData

class TemporalActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding: ActivityTemporalBinding
    private lateinit var textoEstalo:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTemporalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textoEstalo= intent.getStringExtra("estalo").toString()
        binding.textViewEstalo.text=textoEstalo
        binding.buttonAvancarParaConclusao.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id==R.id.button_avancar_para_conclusao){
            validarTemporal()
        }
    }
    fun validarTemporal(){
        avancarParaConclusao()
    }
    fun avancarParaConclusao(){

        val dataFinal= binding.editTextDataFinal.text.toString()
        val expectativaRazoavelPeriodo= binding.editTextOQuePodeSerAlcancado.text.toString()

        SharedData(this).storeString("dataFinal",dataFinal)
        SharedData(this).storeString("expectativaRazoavelPeriodo",expectativaRazoavelPeriodo)

        var intenteConclusao= Intent (this,ConclusaoActivity::class.java)
        intenteConclusao.putExtra("estalo",textoEstalo)
        startActivity(intenteConclusao)
        finish()
    }
}