package com.alis.geektech.models;

import java.io.Serializable;

public class Help implements Serializable {

    private String problemTitle;
    private String problemDescription;
    private String problemFromWhom;

    public Help(String problemTitle, String problemDescription, String problemFromWhom) {
        this.problemTitle = problemTitle;
        this.problemDescription = problemDescription;
        this.problemFromWhom = problemFromWhom;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getProblemFromWhom() {
        return problemFromWhom;
    }

    public void setProblemFromWhom(String problemFromWhom) {
        this.problemFromWhom = problemFromWhom;
    }
}
