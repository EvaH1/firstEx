package com.example.se2_firstex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public TextView textView;
    public TextView serverReply;
    public Button calculateButton;
    public Button serverButton;
    public EditText sendMessage;
    static String input = null;
    static String output = "0";
    PrimeThread primeThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        serverReply = (TextView) findViewById(R.id.textView2);
        calculateButton = (Button) findViewById(R.id.calculateButton);
        serverButton = (Button) findViewById(R.id.serverButton);
        sendMessage = (EditText) findViewById(R.id.editTextNumber);
        calculateButton.setOnClickListener(this);
        serverButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calculateButton:
                try {
                    calculate();
                    serverReply.setText(output);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
        switch (v.getId()) {
            case R.id.serverButton:
                primeThread = new PrimeThread(sendMessage.getText().toString());
                primeThread.start();
                try {
                    primeThread.join();
                    serverReply.setText(primeThread.getModifiedSentence());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    private String calculate() {
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
