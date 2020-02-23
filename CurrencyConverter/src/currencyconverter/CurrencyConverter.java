package currencyconverter;
// ***********************************************************************
// CurrencyConverter.java
//
// Computes the dollar value of the cost of an item in another currency.
// ***********************************************************************
import java.awt.*;
import javax.swing.*;

public class CurrencyConverter {
    public static void main (String[] args) {
        JFrame frame = new JFrame ("Currency Converter");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        RatePanel ratePanel = new RatePanel();
        frame.getContentPane().add(ratePanel);
        frame.setSize(500,250);
        frame.setVisible(true);
    }
}