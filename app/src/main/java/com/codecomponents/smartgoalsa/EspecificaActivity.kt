package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codecomponents.smartgoalsa.databinding.ActivityEspecificaBinding

class EspecificaActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var binding:ActivityEspecificaBinding
    private lateinit var textoEstalo:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEspecificaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textoEstalo= intent.getStringExtra("estalo").toString()
        binding.textViewEstalo.text=textoEstalo
        binding.buttonAvancar1De5.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        if(v.id==R.id.button_avancar_1_de_5){
            validarEspecifica()

        }
    }
    fun validarEspecifica(){
        avancarParaMensuravel()
    }
    private fun avancarParaMensuravel(){
        textoEstalo

        val expectativa=binding.editTextExpectativa.text.toString()
        val importancia=binding.editTextImportancia.text.toString()
        val envolvidos=binding.editTextEnvolvidos.text.toString()
        val recursos= binding.editTextRecursosNecessarios.text.toString()

        val esp = EspecificaModel(0,expectativa,importancia,envolvidos,recursos)

        var intencao= Intent (this,MensuravelActivity::class.java)
        intencao.putExtra("estalo",textoEstalo)
        intencao.putExtra("expectativa",expectativa)
        intencao.putExtra("importancia",importancia)
        intencao.putExtra("envolvidos",envolvidos)
        intencao.putExtra("recursos",recursos)

        startActivity(intencao)
    }
}