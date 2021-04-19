package com.example.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar: Button
    lateinit var mViewModel: MainViewModel
    var contador: Int = 0

    //cria a estrutura do projeto, inicia o layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logar(valor = "onCreate")
        initDados()
        initClick()
    }

    private fun initDados() {
        //implementação do view model
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        txtContador = findViewById(R.id.txtContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)

        //observar a variável dentro do contexto e realizar ação
        mViewModel.mContador.observe(this, Observer { valor ->
            txtContador.setText(valor)
        })
    }

    private fun initClick() {
        btnDados.setOnClickListener{
            mViewModel.contador()
        }

        btnMostrar.setOnClickListener {
            Snackbar.make(it, "Valor Contador: ${mViewModel.mContador.value}", Snackbar.LENGTH_LONG).show()
        }
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
}