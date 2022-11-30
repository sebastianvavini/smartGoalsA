package com.codecomponents.smartgoalsa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codecomponents.smartgoalsa.databinding.ActivityConclusaoBinding

class ConclusaoActivity : AppCompatActivity() {
    private lateinit var binding:ActivityConclusaoBinding
    private lateinit var textoEstalo:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityConclusaoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textoEstalo= intent.getStringExtra("estalo").toString()
        binding.textViewEstalo.text=textoEstalo

    }
}