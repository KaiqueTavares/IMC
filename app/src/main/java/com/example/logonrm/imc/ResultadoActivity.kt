package com.example.logonrm.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.logonrm.imc.extensions.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Estou resgatando as informações que o usuario colocou na outra tela.
        //?.toDouble (CONVERTANDO A STRING EM NUMERO EM KOTLIN)
        val peso = intent?.getStringExtra("PESO")!!.toDouble()
        val altura = intent?.getStringExtra("ALTURA")!!.toDouble()
        //Responsavel pela logica, onde o .div (Divisao), (.times = vezes) e o !!(ESTOU OBRIGANDO O PROGRAMA A RODAR)
        val imc = peso / (altura * altura)
        //Setando o meu inputText (Com meu calculo)
        //tvIMC.setText(imc.toString().substring(0,5))
        //Este .format é um extension minha criada.
        tvIMC.text = imc?.format(1)

        if(imc <= 18.5) {
            alterarTextoStatusIMC("Abaixo do Peso")
            alterarImagensStatusIMC(R.drawable.abaixo)
        }else if (imc <= 24.9){
            alterarTextoStatusIMC("Peso Ideial")
            alterarImagensStatusIMC(R.drawable.ideal)
        }else if (imc <= 29.9){
            alterarTextoStatusIMC("Sobrepeso")
            alterarImagensStatusIMC(R.drawable.sobre)
        }else if (imc <= 34.9){
            alterarTextoStatusIMC("Obesidade I")
            alterarImagensStatusIMC(R.drawable.obesidade)
        }else if (imc <= 39.9){
            alterarTextoStatusIMC("Obesidade II")
            alterarImagensStatusIMC(R.drawable.obesidade)
        }else if (imc > 40){
            alterarTextoStatusIMC("Obesidade III")
            alterarImagensStatusIMC(R.drawable.obesidade)
        }
    }

    //FUNÇÕES NAO PODEM SER CRIADAS DENTRO DE OUTRAS FUN
    //Aqui estou criando uma fun, onde recebe um valor Int e irá trocar a imagem
    //Imagem = Drawable
    fun alterarImagensStatusIMC(idImagem: Int){
        ivStatusIMC.setImageDrawable(ContextCompat.getDrawable(this,idImagem))
    }

    fun alterarTextoStatusIMC(texto: String){
        tvStatusIMC.text = texto
    }
}
