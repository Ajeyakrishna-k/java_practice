package org.practice.miscellaneous.interfaceExamples;

public interface InterfaceTwo {
    public default void interfaceMethod(){
        System.out.println("InterfaceTwo");
    }

    public static void interfaceMethodStatic() {
        System.out.println("InterfaceTwo - static method");
    }
}
