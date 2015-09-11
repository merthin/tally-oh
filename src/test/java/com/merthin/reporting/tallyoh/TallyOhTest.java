package com.merthin.reporting.tallyoh;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TallyOhTest {

    private TallyOh tallyoh;

    @Before
    public void before() {
        tallyoh = new TallyOh();
        tallyoh.configure();
    }

    @Test
    public void testJava() throws IOException, URISyntaxException {
        URL url = getClass().getClassLoader().getResource("Java.java");
        File file = new File(url.toURI());
        Assert.assertEquals(7, tallyoh.tallySlocForFile(file));
    }

    @Test
    public void testText() throws URISyntaxException, IOException {
        URL url = getClass().getClassLoader().getResource("Text.txt");
        File file = new File(url.toURI());
        Assert.assertEquals(4, tallyoh.tallySlocForFile(file));
    }
}
