package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codecomponents.smartgoalsa.databinding.ActivityRealistaBinding
import com.codecomponents.smartgoalsa.shared.SharedData

class RealistaActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityRealistaBinding
    private lateinit var textoEstalo:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityRealistaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textoEstalo= intent.getStringExtra("estalo").toString()
        binding.textViewEstalo.text=textoEstalo
        binding.buttonAvancarParaTemporal.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        if(v.id==R.id.button_avancar_para_temporal){
            validarRealista()
        }
    }
    fun validarRealista(){
        avancarParaTemporal()
    }
    fun avancarParaTemporal(){

        val orcamento=binding.editTextOrcamento.text.toString()
        val recursosNecessarios=binding.editTextRecursosNecessarios.text.toString()

        SharedData(this).storeString("orcamento", orcamento)
        SharedData(this).storeString("TemRecursosNecessarios",recursosNecessarios)


        var intenteTemporal= Intent (this,TemporalActivity::class.java)
        intenteTemporal.putExtra("estalo",textoEstalo)
        startActivity(intenteTemporal)
        finish()
    }
}