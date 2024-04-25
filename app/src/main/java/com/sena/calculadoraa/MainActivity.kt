package com.sena.calculadoraa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.sena.calculadoraa.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    // 0->nada; 1->suma; 2->resta; 3->mult; 4->div
    private lateinit var binding: ActivityMainBinding
    var oper: Int = 0
    var numero1: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnIgual: Button = binding.btnIgual
        val btnBorrar: Button = binding.btnBorrar
        val tv_num1: TextView = binding.tvNum1
        val tv_num2: TextView = binding.tvNum2

        btnIgual.setOnClickListener {
            var num2 = tv_num2.text.toString().toDouble()
            var res = 0.0
            when (oper) {
                1 -> res = numero1 + num2
                2 -> res = numero1 - num2
                3 -> res = numero1 * num2
                4 -> res = numero1 / num2
            }
            tv_num2.setText(res.toString())
            tv_num1.setText("")
        }

        btnBorrar.setOnClickListener {
            tv_num1.setText("")
            tv_num2.setText("")
            oper = 0
        }

        binding.btn0.setOnClickListener { onClick(it) }
        binding.btn1.setOnClickListener { onClick(it) }
        binding.btn2.setOnClickListener { onClick(it) }
        binding.btn3.setOnClickListener { onClick(it) }
        binding.btn4.setOnClickListener { onClick(it) }
        binding.btn5.setOnClickListener { onClick(it) }
        binding.btn6.setOnClickListener { onClick(it) }
        binding.btn7.setOnClickListener { onClick(it) }
        binding.btn8.setOnClickListener { onClick(it) }
        binding.btn9.setOnClickListener { onClick(it) }
        binding.btnPunto.setOnClickListener { onClick(it) }

        binding.btnSumar.setOnClickListener { clicOperacion(it) }
        binding.btnRestar.setOnClickListener { clicOperacion(it) }
        binding.btnMult.setOnClickListener { clicOperacion(it) }
        binding.btnDividir.setOnClickListener { clicOperacion(it) }
    }

    override fun onClick (view: View) {
        var num2 = binding.tvNum2.text.toString()

        when (view.id) {
            R.id.btn0 -> binding.tvNum2.setText(num2 + "0")
            R.id.btn1 -> binding.tvNum2.setText(num2 + "1")
            R.id.btn2 -> binding.tvNum2.setText(num2 + "2")
            R.id.btn3 -> binding.tvNum2.setText(num2 + "3")
            R.id.btn4 -> binding.tvNum2.setText(num2 + "4")
            R.id.btn5 -> binding.tvNum2.setText(num2 + "5")
            R.id.btn6 -> binding.tvNum2.setText(num2 + "6")
            R.id.btn7 -> binding.tvNum2.setText(num2 + "7")
            R.id.btn8 -> binding.tvNum2.setText(num2 + "8")
            R.id.btn9 -> binding.tvNum2.setText(num2 + "9")
            R.id.btnPunto -> binding.tvNum2.setText(num2 + ".")
        }
    }

    private fun clicOperacion(view: View) {
        var num2 = binding.tvNum2.text.toString()
        numero1 = num2.toDouble()
        binding.tvNum2.setText("")

        when (view.id) {
            R.id.btnSumar -> {
                binding.tvNum1.setText(num2 + "+")
                oper = 1
            }
            R.id.btnRestar -> {
                binding.tvNum1.setText(num2 + "-")
                oper = 2
            }
            R.id.btnMult -> {
                binding.tvNum1.setText(num2 + "*")
                oper = 3
            }
            R.id.btnDividir -> {
                binding.tvNum1.setText(num2 + "/")
                oper = 4
            }
        }
    }
}