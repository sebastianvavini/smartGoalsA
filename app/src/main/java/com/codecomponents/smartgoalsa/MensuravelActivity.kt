package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codecomponents.smartgoalsa.databinding.ActivityMensuravelBinding

class MensuravelActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var binding:ActivityMensuravelBinding
    private lateinit var estalo:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMensuravelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        estalo=intent.getStringExtra("estalo").toString()
        binding.textViewEstalo.text=estalo
        binding.buttonAvancar2De5.setOnClickListener(this)

    }
    override fun onClick(v: View) {
        if(v.id==R.id.button_avancar_2_de_5){
            validarMensuravel()
        }
    }

    fun validarMensuravel(){
        avancarParaAtribuivel()
    }
    private fun avancarParaAtribuivel(){
        estalo

        val expectativa=binding.editTextExpectativa.text.toString()
        val ponto_de_chegada=binding.editTextPontoDeChegada.text.toString()
        val metricas=binding.editTextMetricas.text.toString()


        // val esp = MensuravelModel(0,expectativa,expectativa,ponto_de_chegada,metricas)

        var intencao= Intent (this,AtribuivelActivity::class.java)
        intencao.putExtra("estalo",estalo)
        intencao.putExtra("expectativa",expectativa)
        intencao.putExtra("ponto_de_chegada",ponto_de_chegada)
        intencao.putExtra("metricas",metricas)


        startActivity(intencao)
    }
}