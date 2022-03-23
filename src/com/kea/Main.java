package com.kea;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String code = "";
        String desc = "";
        String rate = "";
        ArrayList<Rateinfo> rateinfos = new ArrayList<Rateinfo>();
        Main main = new Main();
        double fraKurs = 1.7;
        double tilKurs = 1.6;
        double beløb = 1.5;
        String slutKode;
        String input;
        Scanner scan = new Scanner(System.in);

        //Instantiating the URL class
        URL url = new URL("https://www.nationalbanken.dk/_vti_bin/DN/DataService.svc/CurrencyRatesXML?lang=da");
        //Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
//        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (sc.hasNext()) {
            String nextLine = sc.next();
//            sb.append(nextLine);
            i++;

            if (i > 12 && i < 181) {
                if (nextLine.contains("code")) {
                    code = nextLine.replaceAll("code=", "").replaceAll("\"", "");
                    System.out.print(nextLine.replaceAll("code=", "").replaceAll("\"", ""));
                } else if (nextLine.contains("desc")) {
                    nextLine = nextLine.replaceAll("desc=", "").replaceAll("\"", "").replaceAll("�", "æ");
                    desc = nextLine;
                    if (nextLine.contains("Euro")) {
                        desc = nextLine;
                        System.out.print(" " + nextLine);
                    } else {
                        nextLine = nextLine + " " + sc.next();
                        nextLine = nextLine.replaceAll("\"", "");
                        System.out.print(" " + nextLine);
                    }
                } else if (nextLine.contains("rate")) {
                    nextLine = nextLine.replaceAll("rate=", "").replaceAll("\"", "").replaceAll(",", ".");
                    rate = nextLine;
                    System.out.print(" " + nextLine);
                    rateinfos.add(new Rateinfo(code, desc, rate));
                }

                if (nextLine.contains("/>")) {
                    System.out.println();
                }

            }

            //Retrieving the String from the String Buffer object
//        String result = sb.toString();
//        System.out.println(result);
        }

        main.print();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Convert from? [VALUTACODE]");
        input = scan.nextLine();
        for (Rateinfo a : rateinfos
        ) {
            if (input.equalsIgnoreCase(a.code)) {
                fraKurs = Double.parseDouble((a.rate));
                System.out.println("Amount: ");
                beløb = Double.parseDouble(scan.nextLine());
                System.out.println("Convert to? [VALUTACODE]");
                slutKode = scan.nextLine();
                for (Rateinfo b : rateinfos
                ) {
                    if (b.code.equalsIgnoreCase(slutKode)) {
                        tilKurs = Double.parseDouble(b.rate);
                        System.out.println(beløb + " " + a.code + " converterted to " + slutKode + " equals " +
                                (beløb * fraKurs / tilKurs + " " + slutKode.toUpperCase(Locale.ROOT)));

                    }
                }


            }
        }

    }


    public void print() {
        System.out.println("" +
                "" +
                "");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("[ Type AUD for Australian dollars");
        System.out.println("Type BGN for Bulgarian lev");
        System.out.println("Type BRL for Brasilian real");
        System.out.println("Type CAD for Canadian dollars");
        System.out.println("Type CHF Switz francs");
        System.out.println("Type CNY Chinese yuans");
        System.out.println("Type CZK for Czech koruna");
        System.out.println("Type EUR for euros");
        System.out.println("Type GBP for British pounds");
        System.out.println("Type HKD for HongKong dollars");
        System.out.println("Type HRK for Croatian kuna");
        System.out.println("Type HUF for Ungarian forint");
        System.out.println("Type IDR for Indonesian rupiah");
        System.out.println("Type ILS for Isralian shekel");
        System.out.println("Type INR for Indian rupee");
        System.out.println("Type ISK for Iceland kroner");
        System.out.println("Type JPY for Japanese yen");
        System.out.println("Type KRW for South Korean won");
        System.out.println("Type MXN for Mexican pesos");
        System.out.println("Type MYR for Malaysian ringgit");
        System.out.println("Type NOK for Norwegian kroner");
        System.out.println("Type NZD for New Zealand");
        System.out.println("Type PHP for Philipinian peso");
        System.out.println("Type PLN for Polish zloty");
        System.out.println("Type RON for Rumanian lei");
        System.out.println("Type RUB for Russian rubels");
        System.out.println("Type SEK for Swedish kroner");
        System.out.println("Type SGD for Singapore dollar");
        System.out.println("Type THB for Thai baht");
        System.out.println("Type TRY for Turkish lira");
        System.out.println("Type USD for American dollar");
        System.out.println("Type ZAR for South African rand ]");

    }


}
