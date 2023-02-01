package com.codecomponents.smartgoalsa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codecomponents.smartgoalsa.databinding.ActivityParcelamentoOfertaBinding

class ParcelamentoOfertaActivity : AppCompatActivity() {

    private lateinit var binding:ActivityParcelamentoOfertaBinding
    private lateinit var textoEstalo:String
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityParcelamentoOfertaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textoEstalo= intent.getStringExtra("estalo").toString()

       binding.textEstaloOfertaParcelamento.text=textoEstalo

    }
}