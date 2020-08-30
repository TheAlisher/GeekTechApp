package com.alis.geektech.models;

import java.io.Serializable;

public class Help implements Serializable {

    private String problemTitle;
    private String problemDescription;

    public Help(String problemTitle, String problemDescription) {
        this.problemTitle = problemTitle;
        this.problemDescription = problemDescription;
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
}
