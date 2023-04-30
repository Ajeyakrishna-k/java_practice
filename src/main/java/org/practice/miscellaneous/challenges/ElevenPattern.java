package org.practice.miscellaneous.challenges;

import java.math.BigInteger;

public class ElevenPattern {

    public void print(int n){
        BigInteger number = BigInteger.valueOf(11);


        for(int i = 0; i < n ; i++){
            System.out.println(number.multiply(number));
            number = number.multiply(BigInteger.TEN).add(BigInteger.ONE);
        }

    }
}
