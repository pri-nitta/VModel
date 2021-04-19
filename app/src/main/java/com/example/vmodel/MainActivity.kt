package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button
    var contador: Int = 0

    //cria a estrutura do projeto, inicia o layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logar(valor = "onCreate")

        initDados()
        initContador()
        initClick()
        validaContador()
    }

    override fun onStart() {
        logar(valor = "onStart")
        super.onStart()
    }

    //activity criada e layout funcionando
    override fun onResume() {
        logar(valor = "onResume")
        super.onResume()
    }

    override fun onPause() {
        logar(valor = "onPause")
        super.onPause()
    }

    override fun onStop() {
        logar(valor = "onStop")
        super.onStop()
    }

    //activity finalizada
    override fun onDestroy() {
        logar(valor = "onDestroy")
        super.onDestroy()
    }

    private fun logar(tag: String = "Ciclo de vida", valor: String){
        Log.d(tag, valor)
    }

    private fun validaContador() {
        if(contador > 5){
            contador = 0
        }
    }

    private fun initClick() {
       btnDados.setOnClickListener{
           contador++
           validaContador()
           initContador()
       }

        btnMostrar.setOnClickListener {
            Snackbar.make(it, "Valor Contador: ${contador.toString()}", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun initContador() {
        txtContador.setText(contador.toString())
    }

    private fun initDados() {
        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)
    }


}