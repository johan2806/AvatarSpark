package com.example.avatarspark

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RegistroActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        setupOnClickListeners()

    }

    private fun setupOnClickListeners(){
        val etNombres = findViewById<EditText>(R.id.etNombres)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)

        btnRegistro.setOnClickListener {

            val nombres = etNombres.text.toString().trim()

            if(validarCampos(nombres))
                guardarDatos(nombres)

                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

        }

    }

    private fun validarCampos(nombres: String): Boolean{

        if (nombres.isEmpty()){
            Toast.makeText(this,"Por favor ingrese su nombre",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun guardarDatos(nombres: String){
        val editor = sharedPreferences.edit()
        editor.putString("nombres",nombres)
        editor.apply()
    }

}