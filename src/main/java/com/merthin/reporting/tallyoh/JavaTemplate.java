package com.merthin.reporting.tallyoh;

public class JavaTemplate implements Template {

    @Override
    public String getEndPattern() {
        return "[;{}]";
    }

    @Override
    public String getSingleLineCommentPattern() {
        return "//";
    }

    @Override
    public String getCommentBlockStartPattern() {
        return "/\\*";
    }

    @Override
    public String getCommentBlockEndPattern() {
        return "\\*/";
    }
}
