package com.example.runkeeper.workshopone.lab1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

public class AssertThatTest
{

    @Test
    public void verify_Matcher() throws Exception
    {
        int age = 30;
        assertThat(age, equalTo(30));
        assertThat(age, is(30));

        assertThat(age, not(equalTo(33)));
        assertThat(age, is(not(33)));
    }

    @Test
    public void verify_multiple_values() throws Exception
    {

        double marks = 100.00;
        assertThat(marks, either(is(100.00)).or(is(90.9)));

        assertThat(marks, both(not(99.99)).and(not(60.00)));

        assertThat(marks, anyOf(is(100.00), is(1.00), is(55.00), is(88.00), is(67.8)));

        assertThat(marks, not(anyOf(is(0.00), is(200.00))));

        assertThat(marks, not(allOf(is(1.00), is(100.00), is(30.00))));
    }

    @Test
    public void verify_collection_values() throws Exception
    {

        List<Double> salary = new ArrayList<Double>();
        salary.add(50.00);
        salary.add(200.00);
        salary.add(500.00);

        assertThat(salary, hasItem(50.00));
        assertThat(salary, hasItems(50.00, 200.00));
        assertThat(salary, not(hasItem(1.00)));
        assertThat(salary, not(hasItems(510.00, 2001.00)));

    }


    @Test
    public void verify_Strings() throws Exception
    {
        String name = "Rosie Jr Ruiz";
        assertThat(name, startsWith("Rosie"));
        assertThat(name, endsWith("Ruiz"));
        assertThat(name, containsString("Jr"));
    }
}
