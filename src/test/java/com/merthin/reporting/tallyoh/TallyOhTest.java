package com.merthin.reporting.tallyoh;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

public class TallyOhTest {

    private TallyOh tallyoh = new TallyOh();

    @Test
    public void test() throws IOException, URISyntaxException {
        URL url = getClass().getClassLoader().getResource("AppTest.java");
        File file = new File(url.toURI());
        tallyoh.tallySlocForFile(file);
    }
}
