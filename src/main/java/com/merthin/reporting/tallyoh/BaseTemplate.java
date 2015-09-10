package com.merthin.reporting.tallyoh;

public class BaseTemplate implements Template {

    public String getEndPattern() {
        return "\\S";
    }

    public String getSingleLineCommentPattern() {
        return "\\S";
    }

}
