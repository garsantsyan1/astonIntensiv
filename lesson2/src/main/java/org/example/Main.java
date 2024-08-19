package org.example;

import org.example.customArrayList.ArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(5);
        ar.add(-5);
        ar.add(0);
        ar.add(14);
        ar.add(7);
        ar.add(2);
        ar.add(3);
        ar.add(47);
        ar.add(15);
        ar.add(-1);
        ar.add(2, 2222222);
        System.out.println(ar.size());
        System.out.println(ar.get(0));
        System.out.println(ar.isEmpty());
        ar.set(0, 1111);
        ar.clear();
        ar.addAll(List.of(5, 7, 8));
        ar.remove(1);
        System.out.println(ar.remove((Object) 8));
        System.out.println(ar.isExists(5));

    }
}