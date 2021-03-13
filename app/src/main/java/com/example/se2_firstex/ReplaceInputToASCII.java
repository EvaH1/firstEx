package com.example.se2_firstex;

public class ReplaceInputToASCII {

    private String input;
    private String output;

    ReplaceInputToASCII(String input) { this.input = input; }

    public String getInput() { return input; }
    public void setInput(String input) { this.input = input; }

    public String getOutput() { return output;}
    public void setOutput(String output) { this.output = output; }

   public String calculate() {
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
