package com.abner.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {//cria/instancia a nossa aplicação
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        Log.w("lifecycle", "entrei no onCreate - criando a tela")
    }
}