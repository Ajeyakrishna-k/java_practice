package org.practice.miscellaneous.interfaceExamples;

public interface InterfaceOne {

    public default void interfaceMethod(){
        System.out.println("InterfaceOne");
    }

    public static void interfaceMethodStatic() {
        System.out.println("InterfaceOne - static method");
    }
}
