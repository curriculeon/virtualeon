package com.github.curriculeon.dto;

import com.github.curriculeon.model.AssistantRequest;

import java.util.StringJoiner;

public class AssistantRequestDto {
    private final AssistantRequest assistantRequest;

    public AssistantRequestDto(AssistantRequest assistantRequest) {
        this.assistantRequest = assistantRequest;
    }

    public String getPrompt() {
        return new StringBuilder()
                .append("I am working such that...<br/>")
                .append(getProjectNameClause())
                .append(getInputClause())
                .append(getOutputClause())
                .append(getExpectedClause())
                .append("What do you think the issue is?")
                .toString();
    }

    public String getExpectedClause() {
        return new StringJoiner("<br/>")
                .add("My expectation could be described as:")
                .add("```")
                .add(assistantRequest.getExpected())
                .add("```")
                .add("")
                .toString();
    }


    public String getInputClause() {
        return new StringJoiner("<br/>")
                .add("My input could be described as:")
                .add("```")
                .add(assistantRequest.getInput())
                .add("```")
                .add("")
                .toString();
    }


    public String getOutputClause() {
        return new StringJoiner("<br/>")
                .add("My output could be described as:")
                .add("```")
                .add(assistantRequest.getOutput())
                .add("```")
                .add("")
                .toString();
    }


    public String getProjectNameClause() {
        return new StringJoiner("<br/>")
                .add("My project could be described as:")
                .add("```")
                .add(assistantRequest.getProjectName())
                .add("```")
                .add("")
                .toString();
    }
}
