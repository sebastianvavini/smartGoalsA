package com.codecomponents.smartgoalsa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codecomponents.smartgoalsa.databinding.ActivityAtribuivelBinding

class AtribuivelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAtribuivelBinding
    private lateinit var estalo:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAtribuivelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewEstalo.text=intent.getStringExtra("estalo").toString()

    }
}