package primes;
// *****************************************************************
// Primes.java
//
// Generates a list of primes less than or equal to the integer
// input by the user.
// *****************************************************************
import java.awt.*;
import javax.swing.*;

public class Primes {
    public static void main (String[] args) {
        JFrame frame = new JFrame("Primes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PrimePanel primePanel = new PrimePanel();
        frame.getContentPane().add(primePanel);
        frame.pack();
        frame.setVisible(true);
    }
}