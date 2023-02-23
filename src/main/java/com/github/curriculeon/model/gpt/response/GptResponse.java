package com.github.curriculeon.model.gpt.response;

import java.util.List;

public class GptResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<GptResponseChoice> choices;
    private GptResponseUsage usage;

    public GptResponse(String id, String object, long created, String model, List<GptResponseChoice> choices, GptResponseUsage usage) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
        this.usage = usage;
    }


    // getters and setters for all fields

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<GptResponseChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<GptResponseChoice> choices) {
        this.choices = choices;
    }

    public GptResponseUsage getUsage() {
        return usage;
    }

    public void setUsage(GptResponseUsage usage) {
        this.usage = usage;
    }
}