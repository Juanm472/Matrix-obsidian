/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomFiles;

import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcher {

    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static int getObjectSize(Object o) {
        return Integer.parseInt( String.valueOf(instrumentation.getObjectSize(o)));
    }
}
