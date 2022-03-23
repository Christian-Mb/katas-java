package com.java.kata.core;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringHashCollisionGeneratorTest {

    private static final int N = 3;
    private static List<String> generatedList = new ArrayList<>();
    private static StringHashCollisionGenerator stringHashCollisionGenerator;

    @BeforeClass
    public static void init() {
        stringHashCollisionGenerator = new StringHashCollisionGenerator(3);
        generatedList.addAll(stringHashCollisionGenerator.getGeneratedList());
        for (String word : generatedList) {
            System.out.println(word);
        }
    }

    @Test
    public void generateThreeString() {
        Assert.assertNotNull(generatedList);
        Assert.assertEquals("Should be 3", 3, generatedList.size());
    }

    @Test
    public void stringsShouldBeDifferent() {
        Assert.assertNotEquals("shouldn't be equal", generatedList.get(0), generatedList.get(1));
        Assert.assertNotEquals("shouldn't be equal", generatedList.get(0), generatedList.get(2));
        Assert.assertNotEquals("shouldn't be equal", generatedList.get(1), generatedList.get(2));
    }

    @Test
    public void hashCodeShouldBeTheSame() {
        Assert.assertEquals("should have the same hashcode", generatedList.get(0).hashCode(), generatedList.get(1).hashCode());
        Assert.assertEquals("should have the same hashcode", generatedList.get(0).hashCode(), generatedList.get(2).hashCode());
        Assert.assertEquals("should have the same hashcode", generatedList.get(1).hashCode(), generatedList.get(2).hashCode());
    }


}
