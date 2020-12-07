package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var ValorA = ""
    var ValorB = ""
    var Operador = ' '
    val Cont = ""
    val Decimal = false
    var Dato: Button? = null
    var Punto = false
    var a: Double = 0.toDouble()
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtResultado = findViewById<View>(R.id.txtResultado) as TextView
        var btn0 = findViewById<View>(R.id.btn0) as Button
        var btn1 = findViewById<View>(R.id.btn1) as Button
        var btn2 = findViewById<View>(R.id.btn2) as Button
        var btn3 = findViewById<View>(R.id.btn3) as Button
        var btn4 = findViewById<View>(R.id.btn4) as Button
        var btn5 = findViewById<View>(R.id.btn5) as Button
        var btn6 = findViewById<View>(R.id.btn6) as Button
        var btn7 = findViewById<View>(R.id.btn7) as Button
        var btn8 = findViewById<View>(R.id.btn8) as Button
        var btn9 = findViewById<View>(R.id.btn9) as Button
        var btnmas = findViewById<View>(R.id.btnMas) as Button
        var btnmenos = findViewById<View>(R.id.btnMenos) as Button
        var btnDiv = findViewById<View>(R.id.btnDiv) as Button
        var btnMulti = findViewById<View>(R.id.btnMulti) as Button
        var btnPotencia = findViewById<View>(R.id.btnPotencia) as Button
        var btnRaiz = findViewById<View>(R.id.btnRaiz) as Button
        var btnIgual = findViewById<View>(R.id.btnIgual) as Button
        var btnBorrar = findViewById<View>(R.id.btnBorrar) as Button
        var btnPunto = findViewById<View>(R.id.btnPunto) as Button
        var btnLimpiar = findViewById<View>(R.id.btnLimpiar) as Button

        btn0.setOnClickListener(this)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnmas.setOnClickListener(this)
        btnmenos.setOnClickListener(this)
        btnDiv.setOnClickListener(this)
        btnMulti.setOnClickListener(this)
        btnPotencia.setOnClickListener(this)
        btnRaiz.setOnClickListener(this)
        btnIgual.setOnClickListener(this)
        btnBorrar.setOnClickListener(this)
        btnPunto.setOnClickListener(this)
        btnLimpiar.setOnClickListener (this)
    }


    override fun onClick(v:View){
        when(v.id){
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.
            btn6, R.id.btn7, R.id.btn8, R.id.btn9 -> numero(v)

            R.id.btnMas, R.id.btnMenos, R.id.btnDiv, R.id.btnMulti,
            R.id.btnPotencia -> boton(v)

            R.id.btnLimpiar, R.id.btnBorrar -> limpiar()

            R.id.btnIgual -> resultado()
            R.id.btnPunto -> punto(v)
        }
    }

    fun numero(v: View) {
        Dato = v as Button
        ValorA = ValorA + Dato!!.text
        txtResultado.setText( ValorA)
    }

    fun boton(v: View) {
        Dato = v as Button
        Operador = Dato!!.text[0]
        ValorB = ValorA
        ValorA = ""
        txtResultado.setText("")
    }

    fun limpiar() {
        ValorA = ""
        ValorB = ""
        txtResultado.setText("")
    }

    fun resultado(){
        var resultado=0.0
        val a:Double
        val b: Double
        if (Operador == '+') {
            resultado = ValorB.toDouble() + ValorA.toDouble()
        } else if (Operador == '-') {
            resultado = ValorB.toDouble() - ValorA.toDouble()
        } else if (Operador == '/') {
            resultado = ValorB.toDouble() / ValorA.toDouble()
        } else if (Operador == '*') {
            resultado = ValorB.toDouble() * ValorA.toDouble()
        } else if (Operador == '^')
        { a = ValorB.toDouble()
            b = ValorA.toDouble()
            resultado = Math.pow(a, b)
        }
        txtResultado!!.text = resultado.toString()
        ValorA = resultado.toString()
        ValorB = ""
    }

    fun punto(v: View) {
        Dato = v as Button
        a = ValorA.toDouble()
        if (a % 1 == 0.0) {
            ValorA += Dato!!.text
            txtResultado!!.text = ValorA
        } else if (a % 1 != 0.0) {
            Punto = true
        }
    }

}