package com.andreseptian.contohintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnMoveActivity;
    Button btnMoveActivityWithData;
    Button btnMoveActivityWithObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveActivityWithData = findViewById(R.id.btn_move_activity_with_data);
        btnMoveActivityWithData.setOnClickListener(this);

        btnMoveActivityWithObject = findViewById(R.id.btn_move_activity_with_object);
        btnMoveActivityWithObject.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_activity :

                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);

                startActivity(moveIntent);

                break;
            case R.id.btn_move_activity_with_data :

                Intent moveIntentWithData = new Intent(MainActivity.this, MoveActivityWithData.class);

                moveIntentWithData.putExtra(MoveActivityWithData.EXTRA_NAME, "Andre Septian");
                moveIntentWithData.putExtra(MoveActivityWithData.EXTRA_AGE, 26);

                startActivity(moveIntentWithData);

                break;
            case R.id.btn_move_activity_with_object :

                Person person = new Person();

                person.setName("Andre Septian");
                person.setAge(26);
                person.setEmail("andre.septian@gmail.com");
                person.setCity("Cikijing");

                Intent moveIntentWithObject = new Intent(MainActivity.this, MoveActivityWithObject.class);

                moveIntentWithObject.putExtra(MoveActivityWithObject.EXTRA_PERSON, person);

                startActivity(moveIntentWithObject);
                break;
        }
    }
}
