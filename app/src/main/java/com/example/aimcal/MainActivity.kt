package com.example.aimcal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.Calendar
import android.app.DatePickerDialog as DatePickerDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn1)
        button.setOnClickListener {

            clickDatePickerButton()
        }
    }

    private fun clickDatePickerButton() {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayofmonth ->},
            Toast.makeText(this, "Button is just clicked", Toast.LENGTH_LONG).show()
            view,
            year,
            month,
            day).show()

    }
}