package com.abner.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        alturaEDT?.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        pesoEDT?.doOnTextChanged { text, _, _, _ ->
            //tituloTXT?.text = text
        }
        calcularBTN?.setOnClickListener{
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
        limparBTN?.setOnClickListener{
            limparCampos()
        }


    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso2 : Float? = peso.toFloatOrNull()
        val altura2 : Float?  = altura.toFloatOrNull()

        if (peso2 != null && altura2 != null) {
            val imc = peso2 / (altura2 * altura2)
            tituloTXT.text = "Seu IMC é \n%.2f".format(imc)
        }
    }

    private fun limparCampos() {
        pesoEDT?.text = null
        alturaEDT?.text = null
        tituloTXT?.text = "IMC"
    }
}