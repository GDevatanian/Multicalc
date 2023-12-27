package com.example.multicalc.ui.scientific_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.multicalc.R

class ScientificCalculatorFragment : Fragment() {

    private lateinit var viewModel: ScientificCalculatorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScientificCalculatorViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scientific_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val inputTextView = view.findViewById<TextView>(R.id.input_text_view)
        val outputTextView = view.findViewById<TextView>(R.id.output_text_view)
        val buttons = view.findViewById<LinearLayout>(R.id.buttons)

        buttons.setOnClickListener { view ->
            val buttonText = view.findViewById<TextView>(R.id.button_text).text.toString()
            viewModel.onButtonClick(buttonText)
            inputTextView.text = viewModel.input
            outputTextView.text = viewModel.output
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
}