package com.company;

import java.io.FileWriter;
import java.io.IOException;

public class Fibonacci_Functions {



    public static int fibonacciBinary(int k) {

        if(k == 1 || k == 0) { // Search for base case
            return k; // return 1 for the final value
        }
        else {
            return fibonacciBinary(k - 1) + fibonacciBinary(k - 2);
        }
        //if not base case make recursive call while summing the sequence
        //makes nk> 2^k/2 calls => Exponential increase with value
    }

    public static Pair<Integer, Integer> fibonacciLinear(int k) {

        if(k == 1 || k == 0) {
            return new Pair(k, 0); //when base case achieved return the 1,0 being last first/second pair
        }
        else {
            Pair pair = fibonacciLinear(k-1); //define the new pair of first/second
            Integer sum = (Integer) pair.first + (Integer) pair.second; //take the sum of the last pair as the the new first
            return new Pair(sum, pair.first); //return the new summed pair and the old first
        }

        //makes k-1 recursive calls
    }

    static int fibonacciTail(int n, int a , int b )
    {

        if (n == 0)
            return a;
        if (n == 1)
            return b;
        return fibonacciTail(n-1, b, a+b);
    }



    public static void main(String args[]) {


        try
        {
            FileWriter fileWriter = new FileWriter("out.txt");
            fileWriter.write("Binary Result: \n");
            fileWriter.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }

        try {
            for(int i = 0; i<=50; i+=5){

                long startTime = System.currentTimeMillis();

                int binaryResult = fibonacciBinary(i);

                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;

                String test = "\nTest for k = " + i + " produced a value of " + binaryResult + " in a total time of " + totalTime + " milliseconds";
                System.out.println(test);

                FileWriter fileWriter = new FileWriter("out.txt", true);
                fileWriter.append(test);
                fileWriter.close();

            }
        }
        catch(IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }

        try
        {
            FileWriter fileWriter = new FileWriter("out.txt", true);
            fileWriter.write("\n\n\nLinear Result: \n");
            fileWriter.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }


        try {

            for(int i = 0; i<=50; i+=5){

                long startTime = System.currentTimeMillis();

                Pair linearResult = fibonacciLinear(i);

                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;

                String test = "\nTest for k = " + i + " produced a value of " + linearResult.first + " in a total time of " + totalTime + " milliseconds";
                System.out.println(test);
                FileWriter fileWriter = new FileWriter("out.txt", true);
                fileWriter.append(test);
                fileWriter.close();
            }
        }
        catch(IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }


        try
        {
            FileWriter fileWriter = new FileWriter("out.txt", true);
            fileWriter.write("\n\n\nTail Result: \n");
            fileWriter.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }


        try {

            for(int i = 0; i<=50; i+=5){

                long startTime = System.currentTimeMillis();

                int linearResult = fibonacciTail(i, 0, 1);

                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;

                String test = "\nTest for k = " + i + " produced a value of " + linearResult + " in a total time of " + totalTime + " milliseconds";
                System.out.println(test);
                FileWriter fileWriter = new FileWriter("out.txt", true);
                fileWriter.append(test);
                fileWriter.close();
            }
        }
        catch(IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }

    }
}


