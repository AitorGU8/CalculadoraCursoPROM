package com.example.calculadoracursoprom

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoracursoprom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var firstNumber = 0.0
    private var secondNumber = 0.0
    private var operation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operation = null


        binding.bt0.setOnClickListener(this)
        binding.bt1.setOnClickListener(this)
        binding.bt2.setOnClickListener(this)
        binding.bt3.setOnClickListener(this)
        binding.bt4.setOnClickListener(this)
        binding.bt5.setOnClickListener(this)
        binding.bt6.setOnClickListener(this)
        binding.bt7.setOnClickListener(this)
        binding.bt8.setOnClickListener(this)
        binding.bt9.setOnClickListener(this)

        binding.btComma.setOnClickListener(this)
        binding.btPlus.setOnClickListener(this)
        binding.btMinus.setOnClickListener(this)
        binding.btMul.setOnClickListener(this)
        binding.btDiv.setOnClickListener(this)
        binding.btEqual.setOnClickListener(this)
        binding.btClear.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.bt0 -> onNumberPressed("0")
            binding.bt1 -> onNumberPressed("1")
            binding.bt2 -> onNumberPressed("2")
            binding.bt3 -> onNumberPressed("3")
            binding.bt4 -> onNumberPressed("4")
            binding.bt5 -> onNumberPressed("5")
            binding.bt6 -> onNumberPressed("6")
            binding.bt7 -> onNumberPressed("7")
            binding.bt8 -> onNumberPressed("8")
            binding.bt9 -> onNumberPressed("9")

            binding.btComma -> onNumberPressed(",")
            binding.btPlus -> ""
            binding.btMinus -> ""
            binding.btMul -> ""
            binding.btDiv -> ""
            binding.btEqual -> ""
            binding.btClear -> ""
        }
    }

    private fun onNumberPressed(number:String){
        renderScreen(number)
    }

    private fun renderScreen(number:String){
        val result:String = if (binding.screen.text == "0" && number!=",")
            number
        else
            "${binding.screen.text}$number"

        binding.screen.text=result
    }

    private fun  checkOperation(){
        if(operation==null)
            firstNumber == binding.screen.text.toString().toDouble()
        else
            secondNumber == binding.screen.text.toString().toDouble()
    }

}