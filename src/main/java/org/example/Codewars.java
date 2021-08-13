package org.example;

import java.util.ArrayList;

import java.util.Iterator;
//import java.util.List;

public class Codewars {
    public static void arrayDiff(int[] a, int[] b) {
        // Your code here
        ArrayList<Integer> aList = new ArrayList<Integer>(a.length);
        for (int i : a) {
            aList.add(i);
        }
        Iterator<Integer> it = aList.iterator();
        while (it.hasNext()) {
            Integer diff = it.next();
            for (int i = 0; i < b.length; i++) {
                if (diff == b[i]) {
                    it.remove();
                }
            }
        }
        Iterator<Integer> it2 = aList.iterator();
        int[] result = new int[aList.size()];
        int j = 0;
        while (it2.hasNext()) {
            Integer res = it2.next();
            result[j++] = res.intValue();
        }

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d ", result[i]);
        }
    }
}

