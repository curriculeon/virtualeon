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
                .append("I am working such that...\n")
                .append(getProjectNameClause())
                .append(getInputClause())
                .append(getOutputClause())
                .append(getExpectedClause())
                .toString();
    }

    public String getExpectedClause() {
        return new StringJoiner("\n")
                .add("My expectation could be described as:")
                .add("```")
                .add(assistantRequest.getExpected())
                .add("```")
                .add("\n")
                .toString();
    }


    public String getInputClause() {
        return new StringJoiner("\n")
                .add("My input could be described as:")
                .add("```")
                .add(assistantRequest.getInput())
                .add("```")
                .add("\n")
                .toString();
    }


    public String getOutputClause() {
        return new StringJoiner("\n")
                .add("My expectation could be described as:")
                .add("```")
                .add(assistantRequest.getOutput())
                .add("```")
                .add("\n")
                .toString();
    }


    public String getProjectNameClause() {
        return new StringJoiner("\n")
                .add("My expectation could be described as:")
                .add("```")
                .add(assistantRequest.getProjectName())
                .add("```")
                .add("\n")
                .toString();
    }
}
