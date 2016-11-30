package com.example.runkeeper.workshopone.lab1;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


public class AssertTest
{

    @Test
    public void assertTrueAndFalseTest() throws Exception
    {
        assertTrue(true);
        assertFalse(false);
    }

    @Test
    public void assertNullAndNotNullTest() throws Exception
    {
        Object myObject = null;
        assertNull(myObject);

        myObject = new String("Some value");
        assertNotNull(myObject);
    }

    @Test
    public void assertEqualsTest() throws Exception
    {
        Integer i = new Integer("5");
        Integer j = new Integer("5");
        ;
        assertEquals(i, j);
    }

    @Test
    public void assertNotSameTest() throws Exception
    {
        Integer i = new Integer("5");
        Integer j = new Integer("5");
        assertNotSame(i, j);
    }

    @Test
    public void assertSameTest() throws Exception
    {
        Integer i = new Integer("5");
        Integer j = i;
        assertSame(i, j);
    }

    @Ignore("John's Runkeeper 5k stuff failing")
    @Test
    public void when_today_is_holiday_then_stop_alarm() throws Exception
    {

    }
}
