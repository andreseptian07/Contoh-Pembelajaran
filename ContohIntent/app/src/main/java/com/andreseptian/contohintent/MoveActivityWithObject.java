package com.andreseptian.contohintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveActivityWithObject extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    TextView tvReceivedObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvReceivedObject = findViewById(R.id.tv_object_received);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + person.getName() +
                "\n Email : " + person.getEmail() +
                "\n Age : " + person.getAge() +
                "\n Location : " + person.getCity();

        tvReceivedObject.setText(text);
    }
}
