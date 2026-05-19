package com.example.app_imc

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var button_calc: Button
    lateinit var editPeso: TextInputEditText
    lateinit var editAltura: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button_calc = findViewById(R.id.button_calc)
        editPeso = findViewById(R.id.peso)
        editAltura = findViewById(R.id.altura)

        // Máscara PESO
        editPeso.addTextChangedListener(object : TextWatcher {
            var isUpdating = false
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (isUpdating) return
                val str = s.toString().replace(".", "")
                if (str.length >= 3) {
                    isUpdating = true
                    val formatado = str.substring(0, str.length - 1) + "." + str.substring(str.length - 1)
                    editPeso.setText(formatado)
                    editPeso.setSelection(formatado.length)
                    isUpdating = false
                }
            }
        })

        // Máscara ALTURA
        editAltura.addTextChangedListener(object : TextWatcher {
            var isUpdating = false
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (isUpdating) return
                val str = s.toString().replace(".", "")
                if (str.length >= 3) {
                    isUpdating = true
                    val formatado = str.substring(0, 1) + "." + str.substring(1, 3)
                    editAltura.setText(formatado)
                    editAltura.setSelection(formatado.length)
                    isUpdating = false
                }
            }
        })

        button_calc.setOnClickListener {
            val pesoVal = editPeso.text.toString().toDoubleOrNull()
            val alturaVal = editAltura.text.toString().toDoubleOrNull()

            if (pesoVal == null || pesoVal !in 10.0..500.0) {
                editPeso.error = "Peso entre 10 e 500kg"
            } else if (alturaVal == null || alturaVal !in 0.5..2.6) {
                editAltura.error = "Altura entre 0.5 e 2.6m"
            } else {
                val intent = Intent(this, resultado_act::class.java)
                intent.putExtra("peso", pesoVal)
                intent.putExtra("altura", alturaVal)
                startActivity(intent)
            }
        }
    }
}