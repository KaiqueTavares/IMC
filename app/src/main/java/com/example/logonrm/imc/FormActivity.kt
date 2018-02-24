package com.example.logonrm.imc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        btLimpar.setOnClickListener {
            //Limpando o meu input text atribuindo um valor em branco
            //O ? (Estou falando para ele rodar a aplicação e verificar se tem o editText)
            inputAltura.editText?.setText("")
            inputPeso.editText?.setText("")
            //Ao Clicar no botão limpar, ele vai colocar o foco no elemento de peso
            inputPeso.editText?.requestFocus()
        }

        btCalcular.setOnClickListener {
            //Quando eu quiser falar com a outra tela usarei o Intent  a (Intenção)
            val telaResultado = Intent(this,ResultadoActivity::class.java)
            //Pegando texto editavel em uma string
            //Aqui pego a val, onde quero pegar o valor dela em uma Variavel (QUE DEI O NOME PESO, PARA RESGATAR ESTE VALOR EM OUTRA TELA), onde acesso meu Input, dentro do seu
            //EditText e ai quero pegar o texto em uma string.
            telaResultado.putExtra("PESO",inputPeso.editText?.text.toString())
            telaResultado.putExtra("ALTURA",inputAltura.editText?.text.toString())
            //Eu starto a tela passando o resultado de minha variavel
            startActivity(telaResultado)
        }

    }
}
