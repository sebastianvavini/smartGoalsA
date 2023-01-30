package com.codecomponents.smartgoalsa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codecomponents.smartgoalsa.databinding.ActivityOfertaBinding

class OfertaActivity : AppCompatActivity() {

    private lateinit var binding:ActivityOfertaBinding
    private lateinit var textoEstalo:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityOfertaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textoEstalo= intent.getStringExtra("estalo").toString()
        binding.textEstaloOferta.text=textoEstalo

    }
}