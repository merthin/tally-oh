package com.merthin.reporting.tallyoh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.regex.Pattern;

public class TallyOh {

    public static void main(String[] args) throws IOException {
        TallyOh tallyoh = new TallyOh();

        for (String file : args) {
            File f = new File(file);
            if (f.isDirectory()) {
                tallyoh.tallySlocForDir(f);
            } else {
                tallyoh.tallySlocForFile(f);
            }
        }
    }

    public void configure() {

    }

    public void tallySlocForDir(File dir) {
    }

    public void tallySlocForFile(File file) throws IOException {
        Template template = getTemplate(file);
        Pattern slocPattern = Pattern.compile(template.getEndPattern());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            System.out.println(line);
        }
    }

    private Template getTemplate(File file) {
        try {
            String mimeType = Files.probeContentType(file.toPath());
            System.out.println(mimeType);
            return templates.getOrDefault(mimeType, new BaseTemplate());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BaseTemplate();
    }

    private HashMap<String, Template> templates = new HashMap<String, Template>();
}
