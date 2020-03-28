package com.mac.datetime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mac.datetime.utils.DatePopupView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.txt_view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePopupView view = new DatePopupView("M/d/yy h:mm a",textView,MainActivity.this);
                view.onFocusChange(v,true);
            }
        });
    }
}
