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
        templates.put("java", new JavaTemplate());
    }

    public void tallySlocForDir(File dir) {
    }

    public int tallySlocForFile(File file) throws IOException {
        Template template = getTemplate(file);
        Pattern commentLinePattern = Pattern.compile("^\\s*" + template.getSingleLineCommentPattern());
        Pattern slocPattern = Pattern.compile(template.getEndPattern());
        Pattern commentStart = Pattern.compile("^\\s*" + template.getCommentBlockStartPattern());
        Pattern commentEnd = Pattern.compile(template.getCommentBlockEndPattern());
        int count = 0;
        boolean inCommentBlock = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (inCommentBlock) {
                    if (commentEnd.matcher(line).find()) {
                        inCommentBlock = false;
                    }
                    continue;
                }
                if (commentLinePattern.matcher(line).find()) {
                    continue;
                }
                if (commentStart.matcher(line).find()) {
                    inCommentBlock = true;
                    continue;
                }
                if (slocPattern.matcher(line).find()) {
                    count++;
                }
            }
        }
        return count;
    }

    private Template getTemplate(File file) {
        try {
            String key = "bogus";
            String mimeType = Files.probeContentType(file.toPath());
            if (mimeType != null) {
                key = mimeType;
            } else {
                String[] tokens = file.toString().split("\\.");
                if (tokens.length > 1) {
                    key = tokens[tokens.length - 1];
                }
            }
            return templates.getOrDefault(key, new BaseTemplate());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new BaseTemplate();
    }

    private HashMap<String, Template> templates = new HashMap<String, Template>();
}
