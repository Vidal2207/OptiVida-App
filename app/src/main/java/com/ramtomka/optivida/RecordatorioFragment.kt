package com.ramtomka.optivida

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecordatorioFragment : Fragment(R.layout.fragment_recordatorio) {

    private lateinit var etTitulo: EditText
    private lateinit var etDate: EditText
    private lateinit var etTime: EditText
    private lateinit var recyclerViewRecordatorios: RecyclerView
    private val recordatoriosList = mutableListOf<Recordatorio>()
    private lateinit var recordatorioAdapter: RecordatorioAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etTitulo = view.findViewById(R.id.etTitulo)
        etDate = view.findViewById(R.id.etDate)
        etTime = view.findViewById(R.id.etTime)
        recyclerViewRecordatorios = view.findViewById(R.id.recyclerViewRecordatorios)

        etDate.setOnClickListener { showDatePickerDialog() }
        etTime.setOnClickListener { showTimePickerDialog() }

        recordatorioAdapter = RecordatorioAdapter(recordatoriosList)
        recyclerViewRecordatorios.adapter = recordatorioAdapter
        recyclerViewRecordatorios.layoutManager = LinearLayoutManager(requireContext())

        val btnCrearRecordatorio: Button = view.findViewById(R.id.btnCrearRecordatorio)
        btnCrearRecordatorio.setOnClickListener { createReminder() }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(childFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        etDate.setText("$day/$month/$year")
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment { hour, minute -> onTimeSelected(hour, minute) }
        timePicker.show(childFragmentManager, "timePicker")
    }

    private fun onTimeSelected(hour: Int, minute: Int) {
        etTime.setText("$hour:$minute")
    }

    private fun createReminder() {
        val titulo = etTitulo.text.toString()
        val selectedDate = etDate.text.toString()
        val selectedTime = etTime.text.toString()

        if (titulo.isNotEmpty() && selectedDate.isNotEmpty() && selectedTime.isNotEmpty()) {
            val recordatorio = Recordatorio(titulo, selectedDate, selectedTime)
            recordatoriosList.add(recordatorio)
            recordatorioAdapter.notifyDataSetChanged()

            Toast.makeText(
                requireContext(),
                "Recordatorio creado: $titulo, $selectedDate a las $selectedTime",
                Toast.LENGTH_SHORT
            ).show()

            etTitulo.text.clear()
            etDate.text.clear()
            etTime.text.clear()
        } else {
            Toast.makeText(
                requireContext(),
                "Completa todos los campos antes de crear el recordatorio",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
