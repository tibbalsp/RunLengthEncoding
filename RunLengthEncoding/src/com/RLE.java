//Author: Patrick Tibbals

package com;
import java.io.IOException;
//Run Length Encoding
class RLE {
     public Printer P;
    //Constructor for printer
    public RLE(Printer printer){
        this.P = printer;
    }

    //Encode Linked list input and print to document
    public void encode(LinkedList list) throws IOException {
        int charCount = 1;
        StringBuilder temp = new StringBuilder();
        LinkedList.Node tempNode = list.head.next;
        LinkedList.Node head = list.head;
        for (int i = 0; i < list.getSize(); i++) {
            if(head.data.equals(tempNode.data)){
                charCount++;
            }else{
                temp.append(charCount).append(head.data);
                charCount = 1;
            }
            if(tempNode.next != null) {
                tempNode = tempNode.next;
                head = head.next;
            }else {
                temp.append(charCount).append(tempNode.data);
            }
        }
        //Variables for Compression ratio
        double listSize = list.getSize()+1;
        double stringSize = temp.length();

        //Print with correct format to document
        Printer.printWriter("[" + list.toStrings() + ":" + (list.getSize() + 1) + "]");
        Printer.printWriter("[" + temp + ":" + temp.length() + "]  [" + (listSize / stringSize) + "]");

    }

    // Decode string input and return linked list of answer
    public LinkedList decode(String input) throws IOException {
        LinkedList list = new LinkedList();
        StringBuilder digit = new StringBuilder();
        char charToRepeat;
        int count;
        for (int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))){
                digit.append(input.charAt(i));
            }else {
                charToRepeat = input.charAt(i);
                if(digit.toString().equals("")){
                    count = 1;
                }else {
                    count = Integer.parseInt(digit.toString());
                }
                digit = new StringBuilder();
                while (count != 0 && count != -1){
                    list.addNode(charToRepeat);
                    count--;
                }
            }
        }
        if(!P.getTest3()){
            Printer.printWriter("["+input+"] ["+list.toStrings()+"]");
        }
        return list;
    }
        boolean equal(LinkedList A, LinkedList B){
            while(A.head != null && B.head !=null){
                if(A.head.data.equals(B.head.data)){
                    A.head = A.head.next;
                    B.head = B.head.next;
                }else {
                    return false;
                }
            }
            return true;
        }
}
