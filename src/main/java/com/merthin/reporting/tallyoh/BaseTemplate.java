package com.merthin.reporting.tallyoh;

public class BaseTemplate implements Template {

    @Override
    public String getEndPattern() {
        return "";
    }

    @Override
    public String getSingleLineCommentPattern() {
        // unmatchable; don't exclude any lines
        return "\\w\\b\\w";
    }

    @Override
    public String getCommentBlockStartPattern() {
        // unmatchable; don't exclude any lines
        return "\\w\\b\\w";
    }

    @Override
    public String getCommentBlockEndPattern() {
        // unmatchable; don't exclude any lines
        return "\\w\\b\\w";
    }

}
