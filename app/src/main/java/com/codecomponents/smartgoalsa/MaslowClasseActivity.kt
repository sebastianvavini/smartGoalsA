package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codecomponents.smartgoalsa.data.model.MetaModel
import com.codecomponents.smartgoalsa.databinding.ActivityMaslowClasseBinding

class MaslowClasseActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMaslowClasseBinding
    private lateinit var textoEstalo:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMaslowClasseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textoEstalo= intent.getStringExtra("estalo").toString()
        binding.buttonMaslow.setOnClickListener(this)
    }

    override fun onClick(v: View) {
       // if()


        var descricaoMeta= binding.textEstaloMaslow.text.toString()
        var meta= MetaModel(0,descricaoMeta)
        //viewModel.insert(meta)
        //Toast.makeText(this,"Chamou insert, Amigo!",Toast.LENGTH_LONG).show()

        var intencao= Intent (this,DemandaActivity::class.java)
        intencao.putExtra("estalo",descricaoMeta)

        startActivity(intencao)

    }
}