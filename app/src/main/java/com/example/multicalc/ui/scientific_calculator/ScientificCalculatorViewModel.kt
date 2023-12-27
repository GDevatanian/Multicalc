package com.example.multicalc.ui.scientific_calculator

import androidx.lifecycle.ViewModel

class ScientificCalculatorViewModel : ViewModel() {

    var input: String = ""
    var output: String = ""

    fun onButtonClick(buttonText: String) {
        // Lógica para procesar el clic del botón y actualizar el estado
        // Aquí puedes agregar la lógica específica de tu calculadora científica
        // por ejemplo, manejar los diferentes tipos de botones (números, operadores, funciones, etc.)
        input += buttonText
        // Realizar el cálculo o procesamiento necesario y actualizar el resultado
        // output = performCalculation()
    }

    fun onDestroy() {
        // Limpiar recursos si es necesario al destruir el fragmento o ViewModel
    }
}
