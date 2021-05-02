package com.example.agecalc

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonDate = findViewById(R.id.Button) as Button

        buttonDate.setOnClickListener {view ->

            clickDatePicker(view)
            Toast.makeText(this, "button clicked", Toast.LENGTH_LONG).show()

        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

       val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, Selectedyear, Selectedmonth, SelecteddayOfMonth ->

            val selectedDate = "$SelecteddayOfMonth/${Selectedmonth+1}/$Selectedyear"
            var DateDisplay = findViewById(R.id.textView4) as TextView
            DateDisplay.setText(selectedDate)

            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val theDate = sdf.parse(selectedDate)


            val SelectedDateinMin = theDate!!.time/60000
            val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
            val currentDateinMin = currentDate!!.time/60000
            val difference = currentDateinMin - SelectedDateinMin

            var Inminutes = findViewById(R.id.textView6) as TextView
            Inminutes.setText(difference.toString())
        }
            ,year
            ,month
            ,day).show()

    }
}