package com.example.logonrm.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Estou resgatando as informações que o usuario colocou na outra tela.
        //?.toDouble (CONVERTANDO A STRING EM NUMERO EM KOTLIN)
        val peso = intent?.getStringExtra("PESO")?.toDouble()
        val altura = intent?.getStringExtra("ALTURA")?.toDouble()
        //Responsavel pela logica, onde o .div (Divisao), (.times = vezes) e o !!(ESTOU OBRIGANDO O PROGRAMA A RODAR)
        val imc = peso?.div(altura!!.times(altura))
        //Setando o meu inputText (Com meu calculo)
        tvIMC.setText(imc.toString().substring(0,5))
    }
}
