package com.codecomponents.smartgoalsa

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
    override fun onClick(v: View?) {

    }
    private fun especifica(){
        val expectativa=SharedData(this).getString("expectativa")
        binding.conclusaoExpectativa.text="Espero: ${expectativa}"

        val importancia= SharedData(this).getString("importancia")
        binding.conclusaoPorqueEImportante.text="Esta meta é importante porque: ${importancia}"

        val envolvidos = SharedData(this).getString("envolvidos")
        binding.conclusaoEnvolvidos.text= "Estão envolvidos: ${envolvidos}"

        val recursos_necessarios= SharedData(this).getString("recursos")
        binding.conclusaoRecursosNecessarios.text="Possuo os recursos necessarios para alcancar a meta?: ${recursos_necessarios}"
    }
    private fun mensuravel(){
        val expectativaEmNumeros =SharedData(this).getString("expectativaEmNumeros")
        binding.conclusaoNumerosEsperados.text="Os números esperados são: ${expectativaEmNumeros}"

        val ponto_de_chegada= SharedData(this).getString("ponto_de_chegada")
        binding.conclusaoMensuravelFoiAlcancadaSe.text="A meta foi alcançada se: ${ponto_de_chegada}"

        val metricas_de_acompanhamento = SharedData(this).getString("metricas")
        binding.conclusaoMensuravelMetricasAcompanhamento.text=
            "Os resultados serão acompanhados pelas metricas: ${metricas_de_acompanhamento}"
    }
    private fun atribuivel(){
        val equipe_responsavel =SharedData(this).getString("responsaveis")
        binding.conclusaoAtribuivelEquipes.text ="Os responsaveis pela execuçao da meta são: ${equipe_responsavel}"
    }
    private fun realista(){
        val orcamento = SharedData(this).getString("orcamento")
        binding.conclusaoRealistaTemOrcamento.text="O orçamento será de: ${orcamento}"

        val recursosNecessarios= SharedData(this).getString("recursosNecessarios")
        binding.conclusaoRecursosNecessarios.text="Os recursos necessário para atingir a meta são: ${recursosNecessarios}"

    }
    private fun temporal(){
        val dataFinal = SharedData(this).getString("dataFinal")
        binding.conclusaoDataFinal.text="A data final desta meta é ${dataFinal}"

        val expectativaRazoavelPeriodo= SharedData(this).getString("expectativaRazoavelPeriodo")
        binding.conclusaoResultadoPlausivel.text=" Um resultado plausivel para o periodo é ${expectativaRazoavelPeriodo}"

    }


}