package com.example.imcapp_a.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.imcapp_a.R

class DashBoardActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView
    lateinit var cardPesarAgora: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        tvNome = findViewById(R.id.tv_dash_nome)
        tvProfissao = findViewById(R.id.tv_dash_profissao)
        tvAltura = findViewById(R.id.tv_dash_altura)
        cardPesarAgora = findViewById(R.id.card_pesar_agora)

        cardPesarAgora.setOnClickListener{
            val abrirPesagem = Intent(this, Pesagem_2::class.java)
            startActivity(abrirPesagem)
        }

        preencherDashboard()

        supportActionBar!!.hide()

    }

    private fun preencherDashboard() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        tvNome.text = arquivo.getString("nome", "xxx")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
    }
}