package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.codecomponents.smartgoalsa.data.model.MetaModel
import com.codecomponents.smartgoalsa.databinding.ActivityOfertaOuDemandaBinding

class OfertaOuDemandaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivityOfertaOuDemandaBinding
    private lateinit var textoEstalo:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOfertaOuDemandaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textoEstalo= intent.getStringExtra("estalo").toString()
        binding.textEstaloOfertaDemanda.text=textoEstalo
        binding.buttonAvancar2.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        if(v.id==R.id.button_avancar_2){
            startValidation()
        }
    }

    fun startValidation(){

        if(binding.demanda.isChecked || binding.oferta.isChecked){



            if(binding.demanda.isChecked){
               

                if(binding.fisiologica.isChecked || binding.seguranca.isChecked || binding.social.isChecked ||binding.estima.isChecked){
                    chamarDemanda()
                }
                else{

                    Toast.makeText(this,"Classefique sua demanda",Toast.LENGTH_LONG).show()

                }

            }
            if(binding.oferta.isChecked){

                if(binding.fisiologica.isChecked || binding.seguranca.isChecked || binding.social.isChecked ||binding.estima.isChecked){
                    chamarOferta()
                }
                else{

                    Toast.makeText(this,"Classefique sua Oferta",Toast.LENGTH_LONG).show()

                }


            }

        }
        else{
            Toast.makeText(this,"Responda se isso é uma Oferta ou uma Demanda", Toast.LENGTH_LONG).show()
        }





    }
    fun chamarOferta(){

        var descricaoMeta= binding.textEstaloOfertaDemanda.text.toString()
        var meta= MetaModel(0,descricaoMeta)
        //viewModel.insert(meta)
        //Toast.makeText(this,"Chamou insert, Amigo!",Toast.LENGTH_LONG).show()

        //var intencao= Intent (this,OfertaActivity::class.java)

        var intencao= Intent (this,OfertaActivity::class.java)
        intencao.putExtra("estalo",descricaoMeta)

        startActivity(intencao)

    }
    fun chamarDemanda(){

        var descricaoMeta= binding.textEstaloOfertaDemanda.text.toString()
        var meta= MetaModel(0,descricaoMeta)
        //viewModel.insert(meta)
        //Toast.makeText(this,"Chamou insert, Amigo!",Toast.LENGTH_LONG).show()

        var intencao= Intent (this,DemandaActivity::class.java)
        intencao.putExtra("estalo",descricaoMeta)

        startActivity(intencao)

    }



}