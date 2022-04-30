// Author: Patrick Tibbals

package com;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

//Class to handle printing
class Printer{
    private static boolean fileStarted = false;
    private static PrintWriter writer;

    private static boolean test3;
    static void setTest3(){
        test3 = true;
    }
    boolean getTest3(){
        return test3;
    }

    static void printWriter(String toPrint) throws IOException {
        //Start New File
        if(!fileStarted) {
            writer = new PrintWriter("Test_Output.txt", String.valueOf(StandardCharsets.UTF_8));
            writer.println(toPrint);
            fileStarted = true;
        //Write to current file
        }else {
            writer.println(toPrint);
        }
    }
    static void endPrint(){
        writer.close();
    }
}
//Class responsible for driving the program and tests
class Driver{
    void fileReader() throws IOException {
        File file = new File("RunLengthEncoding/src/Test_Input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        RLE rle = new RLE(new Printer());
        LinkedList aList;
        LinkedList bList;

        String temp = br.readLine();
        //Start Test 1
        if(temp.contains("Test1")) {
            Printer.printWriter("Test 1: Output for Encoding");
            temp = br.readLine();
            while (!temp.contains("Test2")) {
                aList = new LinkedList().toLinkedList(temp);
                rle.encode(aList);
                temp = br.readLine();
            }
        }
        //Start Test 2
        if(temp.contains("Test2")) {
            Printer.printWriter("Test 2: Output for Decoding");
            temp = br.readLine();
            while (!temp.contains("Test3")) {
                rle.decode(temp);
                temp = br.readLine();
            }
        }
        //Start Test3
        if(temp.contains("Test3")){
            Printer.setTest3();
            Printer.printWriter("Test 3: Output for Equality");
            temp = br.readLine();
            while (temp != null) {
                String[] compareTerms = temp.split(" ");

                if(compareTerms.length >= 2) {
                    aList = rle.decode(compareTerms[0]);
                    bList =  rle.decode(compareTerms[1]);
                    if(!rle.equal(aList,bList)){
                        Printer.printWriter("["+compareTerms[0]+"] ["+compareTerms[1]+"]"+"[False]");
                    }else {
                        Printer.printWriter("[" + compareTerms[0] + "] [" + compareTerms[1] + "]" + "[True]");
                    }
                }else {
                    Printer.printWriter("["+compareTerms[0]+"] [] [False]");
                }
                temp = br.readLine();
            }
        }
        //Close Printer we are done
        Printer.endPrint();
    }
    //Starts the driver class
    public static void main(String[] args) throws IOException {
        Driver driver = new Driver();
        driver.fileReader();

    }

}