package org.practice.miscellaneous.annotations;

import org.practice.UseME;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.PriorityQueue;

public class RunThisRunner {


    public static void runThisAnalyzeAndRun() throws InvocationTargetException, IllegalAccessException {
        UseME useME = UseME.illHelpYouGetAnObject().itWontBeThatEasy().illMakeYouBeg();
        Method[] testCaseMethods = UseME.class.getMethods();


        PriorityQueue<Method> pq  =
                new PriorityQueue<>((m1, m2) -> m2.getAnnotation(RunThis.class).value() - m1.getAnnotation(RunThis.class).value());

        for (Method m : UseME.class.getMethods()) {
            RunThis runThis =  m.getAnnotation(RunThis.class);
            if(runThis != null){
                pq.add(m);
            }
        }

        while(!pq.isEmpty()){
            Method m = pq.remove();
            RunThis runThis = m.getAnnotation(RunThis.class);
            for (int i =0; i<runThis.runOnLoop(); i++) m.invoke(useME);
            if(runThis.runOnlyThis()) break;
        }
    }

}
