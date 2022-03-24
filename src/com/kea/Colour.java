package com.kea;

public class Colour {

    public final String GRØN = "\u001B[32m";
    public final String RESET = "\u001B[0m";
    public final String gul = "\u001B[33m";
    public final String red = "\u001B[31m";


    public String grøn(String input) {
        return GRØN + input + RESET;

    }

    public String gul(String input) {
        return gul + input + RESET;
    }
    public String rød(String input){
        return red + input + RESET;
    }
}
