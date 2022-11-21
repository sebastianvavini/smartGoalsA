package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.codecomponents.smartgoalsa.databinding.ActivitySalaBinding

class SalaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivitySalaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySalaBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // var str= intent.getStringExtra("user_key")

       // binding.textViewWellCome.text="Bem Vindo, $str"
        binding.buttonValidar.setOnClickListener(this)
    }
    override fun onClick(v: View) {
        if(v.id==R.id.button_validar){

            if(binding.editEstalo.text.toString()!="") {
                startValidation()
            }
            else{
                Toast.makeText(this,"Entre com um Texto", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun startValidation(){

        var intencao= Intent (this,EspecificaActivity::class.java)
        intencao.putExtra("estalo",binding.editEstalo.text.toString())

        startActivity(intencao)
    }
}