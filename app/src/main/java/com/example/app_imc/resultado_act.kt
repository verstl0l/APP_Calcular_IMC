package com.example.app_imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class resultado_act : AppCompatActivity() {

    lateinit var pesoTxt : TextView

    lateinit var alturaTxt : TextView

    lateinit var resultadoTxt : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultado)
        enableEdgeToEdge()

        pesoTxt = findViewById(R.id.pesoTxt)
        alturaTxt = findViewById(R.id.alturaTxt)
        resultadoTxt = findViewById(R.id.resultadoTxt)

        val bundle = intent.extras

        if (bundle != null) {

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            pesoTxt.text = "Peso informado $peso kg"
            alturaTxt.text = "Alura informado $altura m"

            val IMC = peso / (altura * altura)

            val resultado = if (IMC < 10.5) {
                "Baixo"
            } else if (IMC in 10.5..24.9){
                "Normal"
            } else if (IMC in 25.0 .. 29.9){
                    "Sobrepeso"
            } else {"Obeso"}

            resultadoTxt.text = resultado
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}