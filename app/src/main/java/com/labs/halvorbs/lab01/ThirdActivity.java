package com.labs.halvorbs.lab01;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    public static final String RESULT_MESSAGE = "com.labs.halvorbs.lab01.RESULT_MESSAGE";
    public static final int RESULTCODE_CHANGED = 1;
    public static final int RESULTCODE_UNCHANGED = 0;

    public static final int REQUEST_CHANGENAME = 0;

    EditText textField;
    Button button;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
        setTitle(String.format("%s - %s", getString(R.string.app_name), getString(R.string.a3_name)));

        linkReferences();
        name = getIntent().getStringExtra(SecondaryActivity.MESSAGE);
        textField.setText(name);
        button.setOnClickListener(activitySwitchButtonClickListener);

    }

    private void linkReferences() {
        button = findViewById(R.id.a3_btn_button);
        textField = findViewById(R.id.a3_field_input);
    }

    private View.OnClickListener activitySwitchButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent activityEndResultIntent = new Intent();
            final int code = (name == textField.getText().toString()) ? RESULTCODE_UNCHANGED : RESULTCODE_CHANGED;
            activityEndResultIntent.putExtra(RESULT_MESSAGE, textField.getText().toString());
            setResult(code, activityEndResultIntent);
            finish();
        }
    };
}
