package com.java.kata.core;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringHashCollisionGenerator implements SameHashCode {

    private static final String[] BASE = new String[]{"Aa", "BB"};
    private int n;
    private Set<String> generatedList;


    public StringHashCollisionGenerator(int n) {
        this.setN(n);
        this.setGeneratedList(generateStrings());
    }

    /**
     * Generate a lisf of Strinf with the same hashcode
     *
     * @return List of String without any duplication
     */
    @Override
    public Set<String> generateStrings() {
        Set<String> set = Stream.generate(this::buildString).limit(n).collect(Collectors.toSet());
        while (set.size() != n) {
            set = Stream.generate(this::buildString).limit(n).collect(Collectors.toSet());
        }
        return set;
    }

    /**
     * Build a string with the same hash code
     *
     * @return String with same hash code
     */
    private String buildString() {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(BASE[rand.nextInt(BASE.length)]);
        }
        return sb.toString();
    }

    public void setN(int n) {
        this.n = n;
    }

    public Set<String> getGeneratedList() {
        return generatedList;
    }

    public void setGeneratedList(Set<String> generatedList) {
        this.generatedList = generatedList;
    }
}
