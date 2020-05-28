package com.company.base.Chapter6;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.Console;
import java.io.IOException;


public class C6Test {
    public static void main(String[] args) throws IOException {
        TimePrinter p = new TimePrinter();
        Timer timer = new Timer(1000, p);
        timer.start();

        System.in.read();
    }


}
