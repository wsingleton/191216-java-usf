package com.revature;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.sql.Time;

public class SorterTest {

    private Sorter sut;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

}
