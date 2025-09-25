package com.example.avatarspark.activities.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.avatarspark.R


class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // Listener for redirection to RegisterActivity
        val startRegister = findViewById<TextView>(R.id.tvRegister)
        startRegister.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        val etEmail = findViewById<EditText>(R.id.miText)
        val etPassword = findViewById<EditText>(R.id.miText2)
        val btnLogin = findViewById<Button>(R.id.btnStart)

        btnLogin.setOnClickListener {
            comparacionLogin(etEmail, etPassword)
        }
    }

    private fun comparacionLogin(etEmail: EditText, etPassword: EditText) {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val savedEmail = sharedPreferences.getString("email", "")
        val savedPassword = sharedPreferences.getString("password", "")
        if (email == savedEmail && password == savedPassword) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
        }
    }
}