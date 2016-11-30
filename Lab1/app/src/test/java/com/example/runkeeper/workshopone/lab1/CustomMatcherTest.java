package com.example.runkeeper.workshopone.lab1;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by davidcrelling on 11/30/16.
 */

public class CustomMatcherTest
{

    private java.util.regex.Matcher matcher;
    private InternationalPhoneNumberFormat internationalPhoneNumberFormat;

    @Before
    public void setUp()
    {
        internationalPhoneNumberFormat = new InternationalPhoneNumberFormat();
    }

    @Test
    public void testPhoneNumberIsNotInternational()
    {
        assertThat("703-626-9855", not(internationalPhoneNumberFormat));
    }

    @Test
    public void testPhoneNumberIsInternational()
    {
        assertThat("+14155552671", is(internationalPhoneNumberFormat));
    }

    private class InternationalPhoneNumberFormat extends BaseMatcher<String>
    {

        @Override
        public boolean matches(Object item)
        {
            //compares object to your custom condition
            String phoneNumber = (String) item;
            String patternString = "^\\+(?:[0-9] ?){6,14}[0-9]$";
            Pattern patternMatcher = Pattern.compile(patternString);
            matcher = patternMatcher.matcher(phoneNumber);
            return matcher.find();
        }

        @Override
        public void describeTo(Description description)
        {
            //add a readable message here that will be thrown if the custom assertThat fails
            description.appendText("PhoneNumber is not in international format");
        }
    }
}
