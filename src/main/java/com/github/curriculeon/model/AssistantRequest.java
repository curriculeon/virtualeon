package com.github.curriculeon.model;

public class AssistantRequest {
    private String projectName;
    private String input;
    private String output;
    private String expected;

    public AssistantRequest(String projectName, String input, String output, String expected) {
        this.projectName = projectName;
        this.input = input;
        this.output = output;
        this.expected = expected;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }
}
