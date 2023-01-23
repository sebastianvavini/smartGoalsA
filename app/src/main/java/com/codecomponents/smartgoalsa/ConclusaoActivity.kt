package com.codecomponents.smartgoalsa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codecomponents.smartgoalsa.databinding.ActivityConclusaoBinding
import com.codecomponents.smartgoalsa.shared.SharedData

class ConclusaoActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivityConclusaoBinding
    private lateinit var textoEstalo:String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityConclusaoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textoEstalo= intent.getStringExtra("estalo").toString()
        binding.textViewEstalo.text=textoEstalo

        binding.buttonCompartilharMeta.setOnClickListener(this)

        // S.M.A.R.T

                especifica()

                mensuravel()

                atribuivel()

                realista()

                temporal()

        // S.M.A.R.T

    }
    override fun onClick(v: View) {
        if(v.id==R.id.button_compartilhar_meta){

            val myIntent =  Intent(Intent.ACTION_SEND);

            myIntent.setType("text/plain");
            val body = compilaTudo();
            val sub = "Your Subject";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
            myIntent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(myIntent, "Share Using"))

        }
    }
    private fun especifica(){
        val expectativa=SharedData(this).getString("expectativa")
        binding.conclusaoExpectativa.text="Expectativa: ${expectativa}"

        val importancia= SharedData(this).getString("importancia")
        binding.conclusaoPorqueEImportante.text="Importancia da META: ${importancia}"

        val envolvidos = SharedData(this).getString("envolvidos")
        binding.conclusaoEnvolvidos.text= "Envolvidos: ${envolvidos}"

        val recursos_necessarios= SharedData(this).getString("recursosNecessarios")
        binding.conclusaoRecursosNecessarios.text="Recursos Necessários: ${recursos_necessarios}"
    }
    private fun mensuravel(){
        val expectativaEmNumeros =SharedData(this).getString("expectativaEmNumeros")
        binding.conclusaoNumerosEsperados.text="Números esperados: ${expectativaEmNumeros}"

        val ponto_de_chegada= SharedData(this).getString("ponto_de_chegada")
        binding.conclusaoMensuravelFoiAlcancadaSe.text="A meta foi alcançada se: ${ponto_de_chegada}"

        val metricas_de_acompanhamento = SharedData(this).getString("metricas")
        binding.conclusaoMensuravelMetricasAcompanhamento.text=
            "Métricas de Acompanhamento: ${metricas_de_acompanhamento}"
    }
    private fun atribuivel(){
        val equipe_responsavel =SharedData(this).getString("responsaveis")
        binding.conclusaoAtribuivelEquipes.text ="Responsáveis pela Execução: ${equipe_responsavel}"
    }
    private fun realista(){
        val orcamento = SharedData(this).getString("orcamento")
        binding.conclusaoRealistaTemOrcamento.text="Orçamento: ${orcamento}"

        val recursosNecessarios= SharedData(this).getString("TemRecursosNecessarios")
        binding.conclusaoRealistaTemRecursosNecessarios.text="Tem os Recursos Necessários? ${recursosNecessarios}"

    }
    private fun temporal(){
        val dataFinal = SharedData(this).getString("dataFinal")
        binding.conclusaoDataFinal.text="Data Final: ${dataFinal}"

        val expectativaRazoavelPeriodo= SharedData(this).getString("expectativaRazoavelPeriodo")
        binding.conclusaoResultadoPlausivel.text=" Um resultado plausivel para o periodo é ${expectativaRazoavelPeriodo}"

    }
    private fun checkout():String{

        return "https://checkout.xgrow.com/47f2f63b-2071-4d1d-bbd2-0a84f83025ca/NzUxMA=="

    }

    private fun compilaTudo():String {

       val result=""" 
       META SMART: ${binding.textViewEstalo.text}
       
  Especifica:
       ${binding.conclusaoExpectativa.text}
                
       ${binding.conclusaoPorqueEImportante.text}
                
       ${binding.conclusaoEnvolvidos.text}
                
       ${binding.conclusaoRecursosNecessarios.text}
                
   Mensurável:
       ${binding.conclusaoNumerosEsperados.text}
                
       ${binding.conclusaoMensuravelFoiAlcancadaSe.text}
                
       ${binding.conclusaoMensuravelMetricasAcompanhamento.text}
       
   Atribuivel:
       ${binding.conclusaoAtribuivelEquipes.text}
       
   Realista:        
       ${binding.conclusaoRealistaTemOrcamento.text}
                
       ${binding.conclusaoRealistaTemRecursosNecessarios.text}
           
   Temporal:         
       ${binding.conclusaoDataFinal.text}
                
       ${binding.conclusaoResultadoPlausivel.text} 
        
   ASSINE A SMARTGOALS E SEJA O PRIMEIRO A RECEBER AS NOVAS FUNCIONALIDADES:
       ${checkout()}
            
        """.trimIndent()
        return result




    }


}