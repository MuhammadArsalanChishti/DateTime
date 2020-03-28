package com.mac.datetime.utils;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DatePopupView implements View.OnFocusChangeListener, DatePickerDialog.OnDateSetListener {

    private TextView editText;
    private Calendar myCalendar;
    private Context context;
    private String dateFormat;
    private SimpleDateFormat sdformat;

    public DatePopupView(String dateFormat, TextView editText, Context ctx){
        this.dateFormat = dateFormat;
        sdformat = new SimpleDateFormat(dateFormat, Locale.US);
        this.editText = editText;
        this.context = ctx;
        this.editText.setOnFocusChangeListener(this);
        myCalendar = Calendar.getInstance();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)     {
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, monthOfYear);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        editText.setText(sdformat.format(myCalendar.getTime()));

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        // TODO Auto-generated method stub
        if(hasFocus){
            new DatePickerDialog(context, this, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    }
}
