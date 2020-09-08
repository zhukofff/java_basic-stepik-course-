package com.company;

import java.sql.SQLOutput;

public class NegativeTextAnalyzer extends KeywordAnalyzer{

    /* Это default constructor
     * constructor does not have a return type and it's
     * should exactly match with class name
     */
    NegativeTextAnalyzer(){
        System.out.println("Default constructor");
    }

    @Override
    public String[] getKeywords(){
        String[] keywords = {":(", ":|", "=("};
        return keywords;
    };

    @Override
    public Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }



}
