package com.example.logonrm.imc

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    val tempoDoSplash = 2500L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Chamando minha função
        carregar()
    }

    fun carregar(){

        Handler().postDelayed({
            // Alt Enter+ mouse na classe que ficar vermelha para fazer o import do package
            startActivity(Intent(this,FormActivity::class.java))
            // Matando minha tela de splash
            finish()
        },tempoDoSplash)
    }
}
