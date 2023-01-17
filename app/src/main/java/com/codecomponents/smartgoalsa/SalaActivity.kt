package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.codecomponents.smartgoalsa.data.model.MetaModel
import com.codecomponents.smartgoalsa.databinding.ActivitySalaBinding
import com.codecomponents.smartgoalsa.viewmodel.CadastroMetaViewModel

class SalaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivitySalaBinding
    private lateinit var viewModel: CadastroMetaViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySalaBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // var str= intent.getStringExtra("user_key")

       // binding.textViewWellCome.text="Bem Vindo, $str"
        binding.buttonValidar.setOnClickListener(this)
        viewModel= ViewModelProvider(this).get(CadastroMetaViewModel::class.java)

        viewModel.salvou.observe(this){
            if (it){
                Toast.makeText(this,"Salvou, Amigo!",Toast.LENGTH_LONG).show()

            }else{
                Toast.makeText(this,"Não Salvou, Amigo!",Toast.LENGTH_LONG).show()
            }
        }


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

        var descricaoMeta= binding.editEstalo.text.toString()
        var meta= MetaModel(0,descricaoMeta)
        //viewModel.insert(meta)
        //Toast.makeText(this,"Chamou insert, Amigo!",Toast.LENGTH_LONG).show()

        var intencao= Intent (this,EspecificaActivity::class.java)
        intencao.putExtra("estalo",descricaoMeta)

        startActivity(intencao)
    }
}