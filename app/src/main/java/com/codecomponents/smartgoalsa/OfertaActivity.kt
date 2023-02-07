package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.codecomponents.smartgoalsa.data.model.MetaModel
import com.codecomponents.smartgoalsa.databinding.ActivityOfertaBinding

class OfertaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivityOfertaBinding
    private lateinit var textoEstalo:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityOfertaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textoEstalo= intent.getStringExtra("estalo").toString()
        binding.textEstaloOferta.text=textoEstalo
        binding.buttonAvancarParaParcelamento.setOnClickListener(this)

    }

    override fun onClick(v: View) {

        if(v.id==R.id.button_avancar_para_parcelamento){

            if(binding.editEstaloPreco.text.toString()!="") {
                startValidation()
                chamarParcelamento()
            }
            else{
                Toast.makeText(this,"Entre com um Texto", Toast.LENGTH_LONG).show()
            }
        }

    }
    fun startValidation(){

        if(binding.PagamentoUnico.isChecked || binding.mensal.isChecked || binding.semanal.isChecked){



            if(binding.PagamentoUnico.isChecked){
                Toast.makeText(this,"Pagamento Unico Selecionado",Toast.LENGTH_LONG).show()


            }
            if(binding.mensal.isChecked){
                Toast.makeText(this,"Pagamento Mesal Selecionado",Toast.LENGTH_LONG).show()

            }
            if (binding.semanal.isChecked){
                Toast.makeText(this,"Pagamento Semanal Selecionado",Toast.LENGTH_LONG).show()
            }

        }
        else{
            Toast.makeText(this,"Responda se isso é uma Oferta ou uma Demanda",Toast.LENGTH_LONG).show()
        }



    }
    fun chamarParcelamento(){

        var descricaoMeta= binding.textEstaloOferta.text.toString()
        var meta= MetaModel(0,descricaoMeta)
        //viewModel.insert(meta)
        //Toast.makeText(this,"Chamou insert, Amigo!",Toast.LENGTH_LONG).show()
        var preco= binding.editEstaloPreco.text.toString()

        var intencao= Intent (this,ParcelamentoOfertaActivity::class.java)
        intencao.putExtra("estalo",descricaoMeta)
        intencao.putExtra("preco",preco)

        startActivity(intencao)


    }

}