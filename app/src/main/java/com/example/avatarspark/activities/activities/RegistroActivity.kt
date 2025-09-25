package com.example.avatarspark.activities.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.avatarspark.R


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
        val etApellidos = findViewById<EditText>(R.id.etApellidos)
        val etCorreos = findViewById<EditText>(R.id.etCorreos)
        val etContraseña = findViewById<EditText>(R.id.etContraseña)
        val etContraseñaDos = findViewById<EditText>(R.id.etContraseñaDos)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)

        btnRegistro.setOnClickListener {

            val nombres = etNombres.text.toString().trim()
            val apellidos = etApellidos.text.toString().trim()
            val correos = etCorreos.text.toString().trim()
            val contraseña = etContraseña.text.toString()
            val contraseñados = etContraseñaDos.text.toString()

            if(validarCampos(nombres,apellidos,contraseña,contraseñados))
                guardarDatos(nombres,apellidos,correos,contraseña,contraseñados)
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

        }

    }

    private fun validarCampos(nombres: String,apellidos: String, contaseña: String, contraseñados: String): Boolean{

        if (nombres.isEmpty()){
            Toast.makeText(this,"Por favor ingrese su nombre",Toast.LENGTH_SHORT).show()
            return false
        }
        if (apellidos.isEmpty()){
            Toast.makeText(this,"Por favor ingrese su apellido",Toast.LENGTH_SHORT).show()
            return false
        }
        if (contaseña.isEmpty()){
            Toast.makeText(this,"Por favor ingrese contraseña",Toast.LENGTH_SHORT).show()
            return false
        }
        if (contraseñados.isEmpty()){
            Toast.makeText(this,"Por favor confirme su contraseña",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun guardarDatos(nombres: String,apellidos: String,correos: String ,contraseña: String, contraseñados: String){
        val editor = sharedPreferences.edit()
        editor.putString("nombres",nombres)
        editor.putString("apellidos",apellidos)
        editor.putString("correos",correos)
        editor.putString("contraseña",contraseña)
        editor.putString("contraseñados",contraseñados)
        editor.apply()
    }

}