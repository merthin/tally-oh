package com.merthin.reporting.tallyoh;

public interface Template {

    String getEndPattern();

    String getSingleLineCommentPattern();

    String getCommentBlockStartPattern();

    String getCommentBlockEndPattern();
}
