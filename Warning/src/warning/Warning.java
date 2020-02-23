package warning;
// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;

public class Warning {
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args) {
        int creditHrs; // number of semester hours earned
        double qualityPts; // number of quality points earned
        double gpa; // grade point (quality point) average
        String line, name, inputName = "students.dat";
        String outputName = "warning.dat";
        
        try {
            // Set up scanner to input file
            Scanner scan = new Scanner(new File(inputName));
                    
            // Set up the output file stream
            PrintWriter outFile = new PrintWriter(new File(outputName));
            
            // Print a header to the output file
            outFile.println();
            outFile.println("Students on Academic Warning");
            outFile.println();
            
            // Process the input file, one token at a time
            while (scan.hasNextLine()) {
                // Get the credit hours and quality points and
                // determine if the student is on warning. If so,
                // write the student data to the output file.
                name = scan.next();
                creditHrs = scan.nextInt();
                qualityPts = scan.nextDouble();
                gpa = qualityPts/(double)creditHrs;
                boolean check1 = gpa < 1.5 && creditHrs < 30;
                boolean check2 = gpa < 1.75 && creditHrs < 60;
                boolean check3 = gpa < 2.0;
                if(check1 || check2 || check3) {
                    outFile.write(name + " " + creditHrs + " " + gpa);
                    outFile.println();
                }
            }
            // Close output file
            outFile.close();
        } catch (FileNotFoundException exception) {
            System.out.println ("The file " + inputName + " was not found.");
        } catch (IOException exception) {
            System.out.println (exception);
        } catch (NumberFormatException e) {
            System.out.println ("Format error in input file: " + e);
        }
    }
}