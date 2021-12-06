package com.example.imcapp_a.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.example.imcapp_a.R
import java.time.LocalDate

class Pesagem_2 : AppCompatActivity() {

    lateinit var tvDataPesagem: TextView
    lateinit var buttonRegistrarPeso: Button
    lateinit var editNovoPeso: EditText
    lateinit var spinnerAtividades: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem_2)

        tvDataPesagem = findViewById(R.id.tv_data_pesagem_2)
        editNovoPeso = findViewById(R.id.editNovoPeso)
        spinnerAtividades = findViewById(R.id.spinnerAtividades)

        buttonRegistrarPeso.setOnClickListener{
            gravarPeso()
        }
    }

    private fun gravarPeso(){
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val editor = arquivo.edit()

        val peso = arquivo.getString("peso","")
        val dataPesagem_2 = arquivo.getString("data_pesagem_2", "")

        editor.putString("data_pesagem", LocalDate.now().toString())
        editor.putString("peso", editNovoPeso.text.toString())
        editor.putInt("nivel_atividade", spinnerAtividades.selectedItemPosition)

        editor.commit()
    }
}