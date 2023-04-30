package org.practice.miscellaneous.mischief;

import org.practice.UseME;

public class ItWontBeThatEasy {

    private UseME useME;
    public ItWontBeThatEasy(UseME useME){
        this.useME = useME;
    }

    public IllMakeYouBeg itWontBeThatEasy(){
        return new IllMakeYouBeg(useME);
    }
}

