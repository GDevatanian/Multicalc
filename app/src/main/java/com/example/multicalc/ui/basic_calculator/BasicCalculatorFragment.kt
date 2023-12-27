package com.example.multicalc.ui.basic_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.multicalc.R

class BasicCalculatorFragment : Fragment() {

    private lateinit var viewModel: BasicCalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BasicCalculatorViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basic_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputTextView = view.findViewById<TextView>(R.id.input_text_view)
        val outputTextView = view.findViewById<TextView>(R.id.output_text_view)

        // Observa los cambios en el LiveData y actualiza la interfaz de usuario
        viewModel.input.observe(viewLifecycleOwner) { inputText ->
            inputTextView.text = inputText ?: ""
        }

        viewModel.output.observe(viewLifecycleOwner) { outputText ->
            outputTextView.text = outputText ?: ""
        }

        // Obtén referencias a los botones
        val buttonIds = arrayOf(
            R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5,
            R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9, R.id.button_0,
            R.id.button_plus, R.id.button_minus, R.id.button_multiply, R.id.button_divide,
            R.id.button_equals, R.id.button_clear,
            R.id.button_unknown_1, R.id.button_unknown_2, R.id.button_unknown_3, R.id.button_unknown_4
        )

        // Configura OnClickListener para cada botón
        for (buttonId in buttonIds) {
            view.findViewById<Button>(buttonId).setOnClickListener {
                val buttonText = (it as Button).text.toString()
                onButtonClick(buttonText)
            }
        }
    }

    private fun onButtonClick(buttonText: String) {
        // Lógica para manejar el clic del botón aquí
        // Puedes obtener el texto del botón u otros detalles según sea necesario
        viewModel.onButtonClick(buttonText)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
}

