package com.surber.matthew.emphasis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button emphasize = (Button) findViewById(R.id.emphasis_button);
        final EditText emphasis_text = (EditText) findViewById(R.id.emphasize_text);

        emphasize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmphasisFragment emphasis = new EmphasisFragment().newInstance(emphasis_text.getText().toString());
                emphasis.show(getFragmentManager(), "Simple Dialog");
            }
        });
    }
}
