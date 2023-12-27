package com.example.multicalc.utils

class Utils {
    companion object {
        fun convertirEnteroSiEsPosible(numero: Double): Any {
            return if (numero % 1 == 0.0) {
                numero.toLong()  // Convertir a Long si es un número entero
            } else {
                numero  // Mantener el valor original si no es un número entero
            }
        }
    }
}