package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codecomponents.smartgoalsa.databinding.ActivityAtribuivelBinding

class AtribuivelActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityAtribuivelBinding
    private lateinit var estalo:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAtribuivelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewEstalo.text=intent.getStringExtra("estalo").toString()
        binding.buttonAvancar3De5.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id==R.id.button_avancar_3_de_5){
            validarAtribuivel()
        }
    }
    fun validarAtribuivel(){
        avancarParaRealista()
    }
    fun  avancarParaRealista(){
        println("Avançar para Nova Activity - Realista")
        var realistaIntent= Intent (this,RealistaActivity::class.java)
        startActivity(realistaIntent)
        finish()

    }
}