package com.example.examen

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class area : AppCompatActivity() {
    private lateinit var nombreTextView: TextView
    private lateinit var txtBase: EditText
    private lateinit var txtAltura: EditText
    private lateinit var txtArea: TextView
    private lateinit var txtPerimetro: TextView
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_area)
        iniciarComponentes()
        eventosClic()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun iniciarComponentes(){
        nombreTextView = findViewById(R.id.Nombre)
        txtBase = findViewById(R.id.txtBase)
        txtAltura = findViewById(R.id.txtAltura)
        txtArea = findViewById(R.id.txtArea)
        txtPerimetro = findViewById(R.id.txtPerimetro)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnCerrar = findViewById(R.id.btnCerrar)

        val strNombre = intent.getStringExtra("Nombre")?: "Nombre desconocido"
        nombreTextView.text = "Tu nombre es: "+ strNombre
    }

    public fun eventosClic(){
        btnCalcular.setOnClickListener(View.OnClickListener {
            if (txtBase.text.toString().contentEquals("")
                || txtAltura.text.toString().contentEquals("")){
                Toast.makeText(this, "Faltó capturar información", Toast.LENGTH_SHORT).show()
            }
            else{
                var base : Float = txtBase.text.toString().toFloat()
                var altura : Float = txtAltura.text.toString().toFloat()
                val area = base * altura
                val perimetro = 2*(altura+base)
                txtArea.setText(area.toString())
                txtPerimetro.setText(perimetro.toString())
            }

        })
        btnLimpiar.setOnClickListener({
            txtPerimetro.setText("")
            txtArea.setText("")
            txtBase.setText("")
            txtAltura.setText("")
        })

        btnCerrar.setOnClickListener({
            finish()
        })
    }
}