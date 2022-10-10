package com.company;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader(".\\src\\main\\resources\\4_klass_Yuschenko_sb_16_00_Otvety");
        System.out.println(reader.getName());
        /*String str = "sosh #28 g. Omska s YIOP\n";
        Pattern pattern = Pattern.compile("\\s*\\w*(\\d*)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find())
            System.out.println(matcher.group());

        /*
        LocalDate date1 = LocalDate.of(2008, 3, 29);
        LocalDate date2 = LocalDate.parse("2008-10-29");
        System.out.println(date1);

        String string = "29.10.2008";
        String[] temp = string.split("\\.");
        System.out.println(LocalDate.of(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0])));
        */
    }
}
