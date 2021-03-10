package com.example.se2_firstex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public TextView textView;
    public TextView serverReply;
    public Button button;
    public static EditText sendMessage;
    static String input = null;
    static String output = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        serverReply = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);
        sendMessage = (EditText) findViewById(R.id.editTextNumber);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                try {
                    calculate();
                    serverReply.setText(output);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private String calculate() throws IOException {
        input = sendMessage.getText().toString();
        char[] chars = input.toCharArray();
        for (int i = 1; i < input.length(); i += 2) {
            if (chars[i] == '0') {
                chars[i] = 'j';
            } else {
                int c = (int) chars[i] + 48;
                char ascii = (char) c;
                chars[i] = ascii;
            }
        }
        output = new String(chars);
        return output;
    }
}
