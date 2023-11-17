package com.example.ejercicio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btnEnviar = findViewById<Button>(R.id.enviar)
        var etNombre = findViewById<EditText>(R.id.nombreUsuario)
        var etCorreo = findViewById<EditText>(R.id.correo)
        var etContra = findViewById<EditText>(R.id.contra)

        btnEnviar.setOnClickListener{

            var bool1 = validNombre(etNombre)
            var bool2 = validCorreo(etCorreo)
            var bool3 = validContra(etContra)
           if( bool1 && bool2 && bool3){
               val intent = Intent(this, Ejercicio2_2::class.java)
               startActivity(intent)
           }
        }

    }
    fun validNombre(etNombre:EditText):Boolean{
        var isValid = true
        if(etNombre.text.isEmpty()){
            etNombre.error = "El campo del nombre no puede estar vacío"
            isValid = false
        }
        return isValid
    }

    fun validCorreo(etCorreo:EditText):Boolean{
        var isValid = false
        if(etCorreo.text.contains("@") && etCorreo.text.contains(".")){
            isValid = true
        }else{
            etCorreo.error = "Debe contener @ y ."
        }
        return isValid
    }
    fun validContra(etContra:EditText):Boolean{
        var isValid = true
        if(etContra.text.length<6){
            etContra.error = "Debe tener al menos 6 carácteres"
            isValid = false
        }
        return isValid
    }
}