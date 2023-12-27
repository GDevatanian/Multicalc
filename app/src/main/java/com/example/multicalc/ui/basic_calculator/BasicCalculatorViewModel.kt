package com.example.multicalc.ui.basic_calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.multicalc.utils.Utils
import net.objecthunter.exp4j.ExpressionBuilder

class BasicCalculatorViewModel : ViewModel() {

    val input = MutableLiveData<String?>()
    val output = MutableLiveData<String?>()

    init {
        input.value = "0"
        output.value = "0"
    }

    fun onButtonClick(buttonText: String) {
        when (buttonText) {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" -> {
                if (input.value == "0") {
                    input.value = buttonText
                } else {
                    input.value += buttonText
                }
            }
            "+", "-", "*", "/" -> {
                // Concatenar el input y el operador
                input.value = "${input.value}$buttonText"
            }
            "=" -> {
                // Calcular el resultado solo cuando se toca el botón "="
                val expression = input.value!!
                val result = evalExpression(expression)
                output.value = result
                input.value = result
            }
            "C" -> {
                // Limpiar el input y el output
                input.value = "0"
                output.value = "0"
            }
        }
    }

    private fun evalExpression(expression: String): String {
        try {
            val result = ExpressionBuilder(expression).build().evaluate()

            // Verificar si el resultado es un número entero
            val formattedResult = Utils.convertirEnteroSiEsPosible(result).toString()

            return formattedResult
        } catch (e: ArithmeticException) {
            // Manejar errores de evaluación de expresiones (por ejemplo, división por cero)
            // Puedes personalizar este manejo de errores según tus necesidades.
            e.printStackTrace()
        }
        return "0"
    }

    fun getInput(): String {
        return input.value!!
    }

    fun getOutput(): String {
        return output.value!!
    }

    override fun onCleared() {
        super.onCleared()
        input.value = null
        output.value = null
    }

    fun onDestroy() {
        input.value = null
        output.value = null
    }
}