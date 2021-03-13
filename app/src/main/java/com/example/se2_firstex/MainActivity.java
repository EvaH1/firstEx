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

    PrimeThread primeThread;
    ReplaceInputToASCII replaceInputToASCII;

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
                    replaceInputToASCII= new ReplaceInputToASCII(sendMessage.getText().toString());
                    serverReply.setText(replaceInputToASCII.calculate());
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


}
