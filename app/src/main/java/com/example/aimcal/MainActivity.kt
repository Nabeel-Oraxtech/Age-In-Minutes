package com.example.aimcal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import android.app.DatePickerDialog as DatePickerDialog

class MainActivity : AppCompatActivity() {
    var tvDate: TextView?=null
    var showMinutes:TextView?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn1)
        tvDate=findViewById(R.id.tvDate)
        showMinutes=findViewById(R.id.showMinutes)
        button.setOnClickListener {

            clickDatePicker()
        }
    }

      fun clickDatePicker() {
         val myCalendar = Calendar.getInstance()
         val year = myCalendar.get(Calendar.YEAR)
         val month = myCalendar.get(Calendar.MONTH)
         val day = myCalendar.get(Calendar.DAY_OF_MONTH)
             val display=DatePickerDialog(this,
                 DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                     Toast.makeText(this,
                         "This app is working fine",
                         Toast.LENGTH_LONG).show()
                     val selectedDate="$dayOfMonth/${month+1}/$year"
                     tvDate?.text=selectedDate
                     val sdf= SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                     val theDate=sdf.parse(selectedDate)
                     val dateInMinutes=theDate.time /6000
                     val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))
                     val curentDateInMinutes=currentDate.time/6000
                     val diffInMinutes=curentDateInMinutes-dateInMinutes
                     showMinutes?.text=diffInMinutes.toString()
                 },
                 year,
                 month,
                 day
             )
          display.datePicker.maxDate=System.currentTimeMillis()-86400000
         display.show()
     }
}