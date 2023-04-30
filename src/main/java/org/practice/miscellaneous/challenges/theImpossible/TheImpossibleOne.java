package org.practice.miscellaneous.challenges.theImpossible;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TheImpossibleOne {

    private final int value;

    public TheImpossibleOne(int value) {
        this.value = value;
    }

    public static List<TheImpossibleOne> getTestData(){
        Random random = new Random();
        List<TheImpossibleOne> input = new ArrayList<>();
        for(int i = 0 ; i < random.nextInt(5,10); i++){
            input.add(new TheImpossibleOne(random.nextInt(random.nextInt(1,100),random.nextInt(101,200))));
        }
        return input;
    }
}
