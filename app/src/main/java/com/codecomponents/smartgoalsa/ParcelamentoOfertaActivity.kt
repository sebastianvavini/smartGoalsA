package com.codecomponents.smartgoalsa

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.codecomponents.smartgoalsa.databinding.ActivityParcelamentoOfertaBinding

class ParcelamentoOfertaActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding:ActivityParcelamentoOfertaBinding
    private lateinit var textoEstalo:String
    private lateinit var textoPrice:String
    private lateinit var recorrencia:String
    private lateinit var qtdParcelas:String
    private lateinit var valorParcela:String

    var parcelas = arrayOf(
        "1x",
        "2x",
        "3x",
        "4x",
        "5x",
        "6x",
        "7x",
        "8x",
        "9x",
        "10x",
        "11x",
        "12x"
    )

    var spinner: Spinner? = null
    var textView_msg: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityParcelamentoOfertaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textoEstalo= intent.getStringExtra("estalo").toString()
        textoPrice=intent.getStringExtra("preco").toString()
        recorrencia=intent.getStringExtra("recorrencia").toString()

        binding.textEstaloOfertaParcelamento.text=textoEstalo
        binding.textPriceOfertaParcelamento.text="Preço: R$ ${textoPrice}"
        binding.textRecorrenciaOfertaParcelamento.text="Recorrencia: ${recorrencia}"

       //----------------------
        spinnerMethod()


    }
    fun spinnerMethod(){
        //textView_msg = this.msg
        textView_msg = binding.msg

        //spinner = this.spinner_sample
        spinner = binding.spinnerSample
        spinner!!.setOnItemSelectedListener(this)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, R.layout.simple_spinner_item, parcelas)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.setAdapter(aa)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        textView_msg!!.text = "Parcelamento em : " + parcelas[position]
        calcularParcela(parcelas[position])
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
    fun  calcularParcela(select:String){

        if(select=="1x"){
            calculaParcela2(1)
        }
        if(select=="2x"){
            calculaParcela2(2)
        }
        if(select=="3x"){
            calculaParcela2(3)
        }
        if(select=="4x"){
            calculaParcela2(4)
        }
        if(select=="5x"){
            calculaParcela2(5)
        }
        if(select=="6x"){
            calculaParcela2(6)
        }
        if(select=="7x"){
            calculaParcela2(7)
        }

        if(select=="8x"){
            calculaParcela2(8)
        }
        if(select=="9x"){
            calculaParcela2(9)
        }
        if(select=="10x"){
            calculaParcela2(10)
        }
        if(select=="11x"){
            calculaParcela2(11)
        }
        if(select=="12x"){
            calculaParcela2(12)
        }

    }
    fun calculaParcela2(qtd:Int){
        valorParcela=(textoPrice.toDouble()/qtd).toString()
        qtdParcelas=(qtd).toString()
        binding.textParcelaQtdParcelas.text="${qtdParcelas} de ${valorParcela}"
    }
}