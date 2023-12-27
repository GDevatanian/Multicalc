package com.example.multicalc.ui.simple_rule_of_three_calculator

import androidx.lifecycle.ViewModel
import com.example.multicalc.utils.Utils

class SimpleRuleOfThreeCalculatorViewModel : ViewModel() {

    var output: String = ""

    fun calculateRuleOfThree(number1: Double, number2: Double, number3: Double) {
        return if (number2 != 0.0) {
            val result = (number1 / number2) * number3
            output = Utils.convertirEnteroSiEsPosible(result).toString()
        } else {
            // Manejar el caso cuando el número2 es 0 para evitar la división por 0
            output = "Error: No se puede dividir por 0"
        }
    }

    fun onDestroy() {
        // Limpiar recursos si es necesario al destruir el fragmento o ViewModel
    }
}
