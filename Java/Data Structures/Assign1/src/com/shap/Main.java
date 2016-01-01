package com.shap;

import java.util.Scanner;
import java.io.*;


public class Main {
    public static final int[] REFERENCE_YEARS = {2007, 2009, 2011};
    public static final int SIZE = 3;

    public static void main(String[] args) throws IOException {
        // File locations
        String out = "Users/Geoff/Google Drive/School/Semester 6/DataStruct/Assign1/report.html";
        String in = "Users/Geoff/Google Drive/School/Semester 6/DataStruct/Assign1/test.csv";
        String Header = "Users/Geoff/Google Drive/School/Semester 6/DataStruct/Assign1/header.html";
        String Footer = "Users/Geoff/Google Drive/School/Semester 6/DataStruct/Assign1/footer.html";

        //Scanners & PrintWriter for the CSV files
        Scanner scan = new Scanner(new FileReader((in)));
        PrintWriter writer = new PrintWriter(new FileWriter((out)));

        // For the pre-made header HTML
        FileReader readHead = new FileReader(Header);

        // For the pre-made footer HTML
        FileReader readFoot = new FileReader(Footer);
        //Reading pre-made header, adding it to the HTML file
        while (readHead.ready()) {
            int incomAscii = readHead.read();
            char convertToChar = (char) incomAscii;
            writer.append(convertToChar);
        }
        writer.append("<h1>Canadian income report for years: ");
        for (int i = 0; i < SIZE-1; i++) {
            writer.append(REFERENCE_YEARS[i] + ", ");
        }
        writer.append(" and " + REFERENCE_YEARS[SIZE-1] + ". </h1>\n");

        // Variables to be used by my logic
        double[] arr = new double[SIZE];
        String geography = "gleb";
        String census = "gleh";
        boolean firstCen = true;
        boolean firstGeo = true;
        Boolean oneDiff = false;
        Boolean twoDiff = false;
        double     diffOne = 0;
        double     diffTwo = 0;
        boolean newGeo = false;

        // Setting delimiter for the scanner to use
        scan.useDelimiter(",|\\r\\n");
        while (scan.hasNextLine()) {
            Record rep = new Record(); // Making a new record variable
            rep.setYear(scan.nextInt()); // Grabbing the year from the CSV file
            String s = scan.next(); // Grabbing the location
            if (s.charAt(0) == '"') { // Is the location two parts
                String temp = s + "," + scan.next(); // Yeah, it is. Let's get the next part
                temp = temp.replace("\"", ""); // Replace the quotation marks with whitespace(deleting them)
                rep.setGeography(temp); // Set the new location into the record
            } else {
                rep.setGeography(s); // It's only one word, set it into the record
            }
            // If it's a new geography, we want to make a new table regardless
            if (!rep.getGeography().equals(geography)) {
                newGeo = true;
                if (!firstGeo) {
                    // If it's not the first geography, we still need to finish the last geography's table
                    // because all data now will need it's own table
                    System.out.print("1\n");
                    for (int i = 0; i < SIZE; i++) {
                        if (arr[i] != 0) {
                            System.out.println(REFERENCE_YEARS[i]);
                            System.out.println(arr[i]);
                            writer.append("<td class=\"v\">" + arr[i] + "</td>\n");

                        } else {

                            writer.append("<td class=\"v\">" + "-" + "</td>\n");
                        }
                    }
                    if(arr[0] !=0 )
                        writer.append("<td class=\"v\">" + String.format("%.5g%n",(arr[SIZE-1]-arr[0])/arr[0])+ "%"+ "</td>\n");
                    else
                        writer.append("<td class=\"v\">" + "-" + "</td>\n");
                    for (int i = 0; i < SIZE; i++) { // Rest the array of values back to 0
                        arr[i] = 0;
                    }
                }
                System.out.println(rep.getGeography());
                if (firstGeo) { // First geography means we just need to print the table headers and no data
                    geography = rep.getGeography();
                    firstGeo = false;
                }
                if (!firstGeo) {
                    geography = rep.getGeography(); // changing to the new geography
                    writer.append("</table>\n<h2>" + geography + "</h2>\n" + "<table class=\"results\">\n"); // Close previous geography's table
                    writer.append("<tr><th>" + "Census Family" + "</th>\n"); // Print table headers
                    writer.append("<th>2007</th>\n<th>2009</th>\n<th>2011</th>\n<th>Difference</th>\n");
                    firstCen = true; // First census type of this geography

                }
            }
            else newGeo = false;

            s = scan.next();
            if (s.charAt(0) == '"') {
                String temp = s + "," + scan.next();
                temp = temp.replace("\"", "");
                rep.setCensusFamilyType(temp);
            } else {
                rep.setCensusFamilyType(s);
            }
            //Not a new census: Don't close the table
            // Exception: If it is a new geography, the census can still be the same as the previous one
            if (!rep.getCensusFamilyType().equals(census) || newGeo) {
                if (!firstCen) { // If it's the time we parse a census, there will be no data to output
                    System.out.print("2\n");
                    for (int i = 0; i < SIZE; i++) {
                        if (arr[i] != 0) {
                            System.out.println(REFERENCE_YEARS[i]);
                            System.out.println(arr[i]);
                            writer.append("<td class=\"v\">" + arr[i] + "</td>\n");
                        } else if (arr[i] == 0) {
                            writer.append("<td class=\"v\">" + "-" + "</td>\n");

                        }

                    }
                    if(arr[0] !=0 )
                        writer.append("<td class=\"v\">" + String.format("%.5g%n",(arr[SIZE-1]-arr[0])/arr[0])+ "%"+ "</td>\n");
                    else
                        writer.append("<td class=\"v\">" + "-" + "</td>\n");
                    for (int i = 0; i < SIZE; i++) {
                        arr[i] = 0;
                    }
                }
                firstCen = false; // Next time we'll have data to output, so it's safe to output
                census = rep.getCensusFamilyType();
                writer.append("<tr></tr>\n");
                writer.append("<td>" + census + "</td>\n");
                System.out.println(rep.getCensusFamilyType());

            }

            census = rep.getCensusFamilyType();
            //writer.append("<td>" + census + "</td>\n");
            scan.next();
            rep.setAmount(scan.nextInt());
            for (int i = 0; i < SIZE; i++) {
                if (rep.getYear() == REFERENCE_YEARS[i])
                    arr[i] = rep.getAmount();
                //System.out.println(arr[i]);
            }

        }
        // The last piece of data needs to be put here because we parsed it all but the loop has ended
        // The loop ended because it doesn't see anymore data lines which means we need to output it
        for (int i = 0; i < SIZE; i++) {
            if (arr[i] != 0) {
                System.out.println(REFERENCE_YEARS[i]);
                System.out.println(arr[i]);
                writer.append("<td class=\"v\">" + arr[i] + "</td>\n");
            } else
                writer.append("<td class=\" v\">" + "-" + "</td>\n");

        }
        if(arr[0] !=0 )
            writer.append("<td class=\"v\">" + String.format("%.5g%n",(arr[SIZE-1]-arr[0])/arr[0])+ "%"+ "</td>\n");
        else
            writer.append("<td class=\"v\">" + "-" + "</td>\n");
        writer.append("</tr>\n</table>\n");
        while (readFoot.ready()) {
            int incomAscii = readFoot.read();
            char convertToChar = (char) incomAscii;
            writer.append(convertToChar);
        }
        writer.close();
        scan.close();
    }
}