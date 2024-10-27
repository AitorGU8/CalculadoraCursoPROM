package com.example.calculadoracursoprom

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadoracursoprom.databinding.ActivityMainBinding

/**
 * MainActivity es la actividad principal de la calculadora, que extiende AppCompatActivity
 * e implementa View.OnClickListener para manejar las interacciones del usuario con la interfaz.
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding // Binding para acceder a las vistas del layout
    private var firstNumber = 0.0 // Primer número ingresado por el usuario
    private var secondNumber = 0.0 // Segundo número ingresado por el usuario
    private var operation: String? = null // Operación a realizar (suma, resta, multiplicación, división)

    /**
     * Método llamado al crear la actividad. Inicializa el binding y configura los
     * listeners para los botones de la calculadora.
     *
     * @param savedInstanceState Estado guardado de la actividad, usado para restaurar la interfaz.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operation = null

        // Configura los listeners para los botones numéricos y de operación
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

    /**
     * Método que maneja los eventos de clic en los botones de la calculadora.
     * Dependiendo del botón presionado, llama al método correspondiente para
     * procesar números u operaciones.
     *
     * @param view La vista que fue clickeada.
     */
    override fun onClick(view: View?) {
        when(view) {
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
            binding.btPlus -> onOperationPressed("+")
            binding.btMinus -> onOperationPressed("-")
            binding.btMul -> onOperationPressed("x")
            binding.btDiv -> onOperationPressed("/")
            binding.btEqual -> onEqualPressed()
            binding.btClear -> onClearPressed()
        }
    }

    /**
     * Método que maneja la entrada de números. Actualiza la pantalla con el número
     * presionado y verifica si hay una operación en curso.
     *
     * @param number El número que fue presionado.
     */
    private fun onNumberPressed(number: String) {
        renderScreen(number)
        checkOperation()
    }

    /**
     * Método que actualiza la pantalla de la calculadora con el número proporcionado.
     *
     * @param number El número que se va a mostrar en la pantalla.
     */
    private fun renderScreen(number: String) {
        val result: String = if (binding.screen.text == "0" && number != ",")
            number
        else
            "${binding.screen.text}$number"

        binding.screen.text = result
    }

    /**
     * Verifica si hay una operación activa. Si no hay operación, asigna el primer
     * número, de lo contrario, asigna el segundo número.
     */
    private fun checkOperation() {
        if (operation == null)
            firstNumber = binding.screen.text.toString().toDouble()
        else
            secondNumber = binding.screen.text.toString().toDouble()
    }

    /**
     * Maneja la selección de una operación. Almacena la operación seleccionada y
     * establece el primer número.
     *
     * @param operation La operación que se va a realizar (suma, resta, multiplicación, división).
     */
    private fun onOperationPressed(operation: String) {
        this.operation = operation
        firstNumber = binding.screen.text.toString().toDouble()

        binding.screen.text = "0"
    }

    /**
     * Método que se ejecuta al presionar el botón de igual. Realiza la operación
     * seleccionada y muestra el resultado en la pantalla.
     */
    private fun onEqualPressed() {
        val result = when (operation) {
            "+" -> firstNumber + secondNumber
            "-" -> firstNumber - secondNumber
            "x" -> firstNumber * secondNumber
            "/" -> firstNumber / secondNumber
            else -> 0
        }
        operation = null
        firstNumber = result.toDouble()

        try {
            binding.screen.text = if (result.toString().endsWith(".0")) {
                result.toString().replace(".0", "")
            } else {
                "%.2f".format(result)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Método que reinicia la calculadora. Limpia la pantalla y restablece los
     * números y la operación a su estado inicial.
     */
    private fun onClearPressed() {
        binding.screen.text = "0"
        firstNumber = 0.0
        secondNumber = 0.0
    }
}
