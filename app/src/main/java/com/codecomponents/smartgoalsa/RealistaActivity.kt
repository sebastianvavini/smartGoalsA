package com.codecomponents.smartgoalsa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codecomponents.smartgoalsa.databinding.ActivityRealistaBinding

class RealistaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRealistaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityRealistaBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}