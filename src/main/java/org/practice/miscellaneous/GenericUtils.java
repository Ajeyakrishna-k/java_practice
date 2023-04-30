package org.practice.miscellaneous;

import org.practice.miscellaneous.annotations.RunThis;

import java.math.BigInteger;
import java.util.Random;

public class GenericUtils {

    public static int[] randomArray(int size, int maxValue){
        int[] result = new int[size];
        Random random = new Random();
        for(int i = 0; i <result.length; i++){
            result[i] = random.nextInt(maxValue);
        }
        return result;
    }

    public static boolean isArraySorted(int arr[]){
        for(int i = 0; i <arr.length - 1; i++){
            if(arr[i+1] < arr[i]) return false;
        }
        return true;
    }

    public static String[] subsequence(String s){
        if(s.length() == 0) return new String[]{""};

        String[] recursionResult = subsequence(s.substring(1));
        int m = recursionResult.length;
        int n = 2 * m;
        String[] result = new String[n];

        System.arraycopy(recursionResult, 0, result, 0, m);

        for (int i = 0; i < m; i++) {
            result[i+m] =  s.charAt(0) + recursionResult[i];
        }
        return result;
    }

    public static void printSubsequence(String input, String baseCase){

        if(input.length() == 0){
            if(baseCase.length() == 0)
                System.out.print("'' ");
            else
                System.out.print(baseCase + " ");
            return;
        }
        char c = input.charAt(0);
        String substring = input.substring(1);
        printSubsequence(substring,baseCase+c);
        printSubsequence(substring,baseCase);
    }
    public static String[] permutationOfString(String input){
        if(input.length() == 0){
            String[] output = {""};
            return output;
        }
        String[] smallerOutput = permutationOfString(input.substring(1));

        String output[] = new String[input.length()*smallerOutput.length];

        int k =0;
        for(int i = 0; i < smallerOutput.length; i++){
            String currentString = smallerOutput[i];
            for(int j = 0; j <= currentString.length(); j++){
                output[k] = currentString.substring(0, j) + input.charAt(0) + currentString.substring(j);
                k++;
            }
        }
        return output;
    }

    public static String ASCIIBinaryToString(String binary){
        BigInteger bigInteger = new BigInteger(binary,2);


        String bis = bigInteger.toString();


        StringBuilder s = new StringBuilder();
        int jump;
        for(int i = 0; i < bis.length(); i+=jump){

            StringBuilder s1 =  new StringBuilder();

            if(bis.charAt(i) == '1'){
                jump = 3;
            }
            else{
                jump = 2;
            }

            for(int j = 0 ; j < jump; j++){

                s1.append(bis.charAt(i+j));
            }

            char c  = (char) Integer.parseInt(s1.toString());

            s.append(c);
        }

        return s.toString();
    }

    public static String StringToASCIIToBinary(String message){
        StringBuilder s = new StringBuilder();
        for(int i = 0 ; i<message.length(); i++){
           s.append((int) message.charAt(i));
        }
        BigInteger bigInteger = new BigInteger(s.toString());
        return bigInteger.toString(2);
    }

}
