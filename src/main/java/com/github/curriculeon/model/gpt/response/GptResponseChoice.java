package com.github.curriculeon.model.gpt.response;

public class GptResponseChoice {
    private String text;
    private int index;
    private Object logprobs; // Can be null or an array of objects
    private String finish_reason;

    public GptResponseChoice(String text, int index, Object logprobs, String finish_reason) {
        this.text = text;
        this.index = index;
        this.logprobs = logprobs;
        this.finish_reason = finish_reason;
    }
    // getters and setters


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object getLogprobs() {
        return logprobs;
    }

    public void setLogprobs(Object logprobs) {
        this.logprobs = logprobs;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }
}