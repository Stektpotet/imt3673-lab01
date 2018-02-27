package com.labs.halvorbs.lab01;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    public static final String PREF_DROPDOWN = "com.labs.halvorbs.lab01.DROPDOWN";
    public static final String TEXT_MESSAGE = "com.labs.halvorbs.lab01.MESSAGE";

    private static final String PREF_DROPDOWN_ELEMENT = "dropdown_pref";

    Button switchActivityButton;
    EditText textField;
    Spinner dropdown;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
        setTitle(String.format("%s - %s", getString(R.string.app_name), getString(R.string.a1_name)));

        linkReferences();

        SharedPreferences prefs = getSharedPreferences(PREF_DROPDOWN, MODE_PRIVATE);
        dropdown.setSelection(prefs.getInt(PREF_DROPDOWN_ELEMENT,0));

        switchActivityButton.setOnClickListener(activitySwitchButtonClickListener);
    }

    private void linkReferences() {
        switchActivityButton = findViewById(R.id.a1_btn_button);
        textField = findViewById(R.id.a1_field_editText);
        dropdown = findViewById(R.id.a1_dropdown_dropdown);
    }
    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = getSharedPreferences(PREF_DROPDOWN, MODE_PRIVATE).edit();
        editor.putInt(PREF_DROPDOWN_ELEMENT, dropdown.getSelectedItemPosition());
        editor.apply();
    }

    private OnClickListener activitySwitchButtonClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent activitySwitchIntent = new Intent(MainActivity.this, SecondaryActivity.class);
            String message = textField.getText().toString();
            activitySwitchIntent.putExtra(TEXT_MESSAGE, message);
            startActivity(activitySwitchIntent);
        }
    };
}
