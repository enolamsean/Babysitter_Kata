package com.seanmalone.babysitter;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import static org.junit.Assert.*;

public class BabySitterTest {
    private BabySitter babySitterTestObject;

    @Before
    public void setUp() throws Exception {
        babySitterTestObject = new BabySitter();
    }

    @Test
    public void validateInputStartTime() {
        assertTrue(babySitterTestObject.validateInputTime(17));
    }
      /*@After
    public void tearDown() throws Exception {
    }*/
}

