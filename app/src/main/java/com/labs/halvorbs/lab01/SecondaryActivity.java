package com.labs.halvorbs.lab01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class SecondaryActivity extends AppCompatActivity {

    public static final String MESSAGE = "com.labs.halvorbs.lab01.MESSAGE";

    TextView textField0;
    TextView textField1;
    Button button;

    String name0, name1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);
        setTitle(String.format("%s - %s", getString(R.string.app_name), getString(R.string.a2_name)));
        linkReferences();

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        name0 = intent.getStringExtra(MainActivity.TEXT_MESSAGE);

        textField0.setText(String.format("Hello %s", name0));
        button.setOnClickListener(activitySwitchButtonClickListener);
    }

    private void linkReferences() {
        textField0 = findViewById(R.id.a2_txtView_view01);
        textField1 = findViewById(R.id.a2_txtView_view02);
        button = findViewById(R.id.a2_btn_button1);
    }

    private View.OnClickListener activitySwitchButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent activitySwitchIntent = new Intent(SecondaryActivity.this, ThirdActivity.class);
            activitySwitchIntent.putExtra(MESSAGE, name1);
            startActivityForResult(activitySwitchIntent, ThirdActivity.REQUEST_CHANGENAME);
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Log.wtf("WTF", data.getStringExtra(ThirdActivity.RESULT_MESSAGE));
        if (requestCode == ThirdActivity.REQUEST_CHANGENAME) {
            if (resultCode == ThirdActivity.RESULTCODE_CHANGED) {
                name1 = data.getStringExtra(ThirdActivity.RESULT_MESSAGE);
                textField1.setText(String.format("From A3: %s", name1));
            }
        }
    }
}
