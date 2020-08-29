package com.alis.geektech.models;

public class Project {

    private int projectLogo;
    private String projectName;
    private String projectGit;
    private String projectPlayMarket;
    private boolean isProjectGit;
    private boolean isProjectPlayMarket;

    public Project(int projectLogo, String projectName, String projectGit, String projectPlayMarket, boolean isProjectGit, boolean isProjectPlayMarket) {
        this.projectLogo = projectLogo;
        this.projectName = projectName;
        this.projectGit = projectGit;
        this.projectPlayMarket = projectPlayMarket;
        this.isProjectGit = isProjectGit;
        this.isProjectPlayMarket = isProjectPlayMarket;
    }

    public int getProjectLogo() {
        return projectLogo;
    }

    public void setProjectLogo(int projectLogo) {
        this.projectLogo = projectLogo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectGit() {
        return projectGit;
    }

    public void setProjectGit(String projectGit) {
        this.projectGit = projectGit;
    }

    public String getProjectPlayMarket() {
        return projectPlayMarket;
    }

    public void setProjectPlayMarket(String projectPlayMarket) {
        this.projectPlayMarket = projectPlayMarket;
    }

    public boolean isProjectGit() {
        return isProjectGit;
    }

    public void setProjectGit(boolean projectGit) {
        isProjectGit = projectGit;
    }

    public boolean isProjectPlayMarket() {
        return isProjectPlayMarket;
    }

    public void setProjectPlayMarket(boolean projectPlayMarket) {
        isProjectPlayMarket = projectPlayMarket;
    }
}
