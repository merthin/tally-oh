package com.merthin.reporting.tallyoh;

public class JavaTemplate implements Template {

    public String getEndPattern() {
        return ";";
    }

    public String getSingleLineCommentPattern() {
        return "////";
    }

}
