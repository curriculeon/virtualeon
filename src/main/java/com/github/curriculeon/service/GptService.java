package com.github.curriculeon.service;

import com.github.curriculeon.dto.AssistantRequestDto;
import com.github.curriculeon.model.AssistantRequest;
import com.github.curriculeon.model.gpt.request.GptSimpleRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class GptService {
    private RestTemplate restTemplate;

    public GptService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> query(String prompt, String token) {
        String url = "https://api.openai.com/v1/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + token);

        Map<String, Object> data = new HashMap<>();
        data.put("model", "text-davinci-003");
        data.put("prompt", prompt);
        data.put("temperature", 0.5);
        data.put("max_tokens", 2048);
        data.put("top_p", 1);
        data.put("frequency_penalty", 0);
        data.put("presence_penalty", 0);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response;
    }


    public ResponseEntity<String> assist(AssistantRequest assistantRequest) {
        return query(getQuestion(assistantRequest).getBody(), "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");
    }


    public ResponseEntity<String> getQuestion(AssistantRequest assistantRequest) {
        final String prompt = new AssistantRequestDto(assistantRequest).getPrompt();
        System.out.println(prompt);
        return new ResponseEntity<>(prompt, HttpStatus.OK);
    }

    public ResponseEntity<String> awaken() {
        return new ResponseEntity<>("Service awakened.", HttpStatus.OK);
    }
}
