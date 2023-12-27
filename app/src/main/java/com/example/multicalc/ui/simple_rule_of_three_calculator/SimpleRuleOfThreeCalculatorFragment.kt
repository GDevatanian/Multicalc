package com.example.multicalc.ui.simple_rule_of_three_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.multicalc.R

class SimpleRuleOfThreeCalculatorFragment : Fragment() {

    private lateinit var viewModel: SimpleRuleOfThreeCalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SimpleRuleOfThreeCalculatorViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_simple_rule_of_three_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputTextView1 = view.findViewById<EditText>(R.id.input_number_1)
        val inputTextView2 = view.findViewById<EditText>(R.id.input_number_2)
        val inputTextView3 = view.findViewById<EditText>(R.id.input_number_3)
        val resultTextView = view.findViewById<TextView>(R.id.result_text_view)
        val errorTextView = view.findViewById<TextView>(R.id.error_text_view)
        val calculateButton = view.findViewById<Button>(R.id.calculate_button)

        calculateButton.setOnClickListener {
            val number1 = inputTextView1.text.toString().toDoubleOrNull()
            val number2 = inputTextView2.text.toString().toDoubleOrNull()
            val number3 = inputTextView3.text.toString().toDoubleOrNull()

            if (number1 != null && number2 != null && number3 != null) {
                // Resetear el mensaje de error y calcular
                errorTextView.visibility = View.INVISIBLE
                viewModel.calculateRuleOfThree(number1, number2, number3)
                    if (isErrorOutput(viewModel.output)) {
                        errorTextView.visibility = View.VISIBLE
                        errorTextView.text = viewModel.output
                        resultTextView.text = "Resultado"
                    } else {
                        resultTextView.text = viewModel.output
                    }
            } else {
                // Mostrar mensaje de error general
                errorTextView.text = "Ingrese números válidos"
                errorTextView.visibility = View.VISIBLE
                resultTextView.text = "Resultado"
            }

        }
    }

    private fun isErrorOutput(input: String): Boolean {
        val lowercaseInput = input.lowercase()
        return lowercaseInput.contains("error")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
}