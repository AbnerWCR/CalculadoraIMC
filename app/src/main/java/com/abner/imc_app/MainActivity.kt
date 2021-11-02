package com.abner.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
            val avaliacao : String = avaliadorIMC(imc.toString())

            alertaTXT?.text = avaliacao
        }
        alertaTXT?.visibility = View.VISIBLE
    }

    private fun limparCampos() {
        pesoEDT?.text = null
        alturaEDT?.text = null
        tituloTXT?.text = "IMC"
        alertaTXT?.text = null

        alertaTXT?.visibility =  View.INVISIBLE
    }

    private fun avaliadorIMC(imc: String) : String{
        Log.w("avaliador", "imc ${imc}")
        val imc : Float = imc.toFloat()
        val magreza : Float         = 18.5.toFloat()
        val ideal : Float           = 24.9.toFloat()
        val sobrepeso : Float       = 29.9.toFloat()
        val obesidade : Float       = 39.9.toFloat()

        val result =  when {
                                imc.compareTo(magreza) < 0          ->  "Magreza"
                                imc > magreza && imc < ideal        -> "Peso ideal"
                                imc > ideal && imc < sobrepeso      -> "Sobrepeso I"
                                imc > sobrepeso && imc < obesidade  -> "Obesidade II"
                                imc.compareTo(sobrepeso) > 0        -> "Obesidade Grave III"
                                else -> "indefinido"
                            }
        return result
    }

}