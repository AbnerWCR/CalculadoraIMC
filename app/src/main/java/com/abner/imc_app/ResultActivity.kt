package com.abner.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("lifecycle", "entrei no onCreate - iniciando aplicação")
        //finish() -- caso em que o ciclo não é respeitado pois vai do onCreate() --> onDestroy()
    }


    override fun onStart() {// criação dos componentes na tela
        super.onStart()
        Log.w("lifecycle", "entrei no onStart - criando componentes")
    }

    override fun onResume() {//autorização para utilizar a aplicaçãp
        super.onResume()
        Log.w("lifecycle", "entrei no onResume - app pornto para uso")
    }

    override fun onPause() {//foco perdido - o usuario deixou a aplicação
        super.onPause()
        Log.w("lifecycle", "entrei no onPause - usuario deixou a aplicação")
    }

    override fun onStop() {// tela parada - não esta mais ativa, necessita de um onRestart
        super.onStop()
        Log.w("lifecycle", "entrei no onStop - aplicação não está mais ativa, necessita de um onRestart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.w("lifecycle", "entrei no onRestart - aplicação voltando")
    }

    override fun onDestroy() {//aplicação destruida, para voltar ao app necessita de um onCreate
        super.onDestroy()
        Log.w("lifecycle", "entrei no onDestroy - aplicação destruida, para retornar necessita de um onCreate")
    }
}