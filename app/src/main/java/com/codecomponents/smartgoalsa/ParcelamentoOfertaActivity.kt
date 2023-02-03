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

       binding.textEstaloOfertaParcelamento.text=textoEstalo

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
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}