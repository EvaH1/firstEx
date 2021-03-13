package com.example.se2_firstex;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class PrimeThread extends Thread {

    private String minPrime;
    private String modifiedSentence;

    PrimeThread(String minPrime) {
        this.minPrime = minPrime;
    }

    public String getMinPrime() {
        return minPrime;
    }
    public void setMinPrime(String minPrime) {
        this.minPrime = minPrime;
    }

    public String getModifiedSentence() {
        return modifiedSentence;
    }
    public void setModifiedSentence(String modifiedSentence) { this.modifiedSentence = modifiedSentence; }


    public void run() {

        try {
            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(minPrime + '\n');
            modifiedSentence = inFromServer.readLine();

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
