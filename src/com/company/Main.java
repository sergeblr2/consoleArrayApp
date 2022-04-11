package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Running");
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(0);
        ints.add(1);
        ints.add(0);
        ints.add(2);

        // first version
        Integer count = 0;
        for (Integer i: ints) {
            if(i == 0) {
                count++;
            }
        }
        ints.removeAll(Arrays.asList(0));
        while(count > 0) {
            ints.add(0);
            count--;
        }
        System.out.println(ints);


       //second version via iterator
        ArrayList<Integer> ints2 = new ArrayList<>(Arrays.asList(3, 0, 1, 0, 2));
        Iterator<Integer> it = ints2.iterator();
        count = 0;
        while(it.hasNext()) {
            Integer i = it.next();
            if(i == 0) {
                it.remove();
                count++;
            }
        }
        while(count > 0) {
            ints2.add(0);
            count--;
        }
        System.out.println(ints2);


        // third via streams
        ArrayList<Integer> ints3 = new ArrayList<>(Arrays.asList(3, 0, 1, 0, 2));
        ints3 = ints3.stream()
                .sorted((i1, i2) -> i1.equals(new Integer(0)) ? 1 : i2.equals(0) ? -1 : 0)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(ints3);
    }
}
