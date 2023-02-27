package com.github.curriculeon.controller;

import com.github.curriculeon.dto.AssistantRequestDto;
import com.github.curriculeon.model.AssistantRequest;
import com.github.curriculeon.model.gpt.request.GptSimpleRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/gpt")
public class GptController {
    private RestTemplate restTemplate;

    public GptController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/query")
    public ResponseEntity<String> query(
            @RequestBody GptSimpleRequest requestObject) {
        String url = "https://api.openai.com/v1/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + requestObject.getToken());

        Map<String, Object> data = new HashMap<>();
        data.put("model", "text-davinci-003");
        data.put("prompt", requestObject.getPrompt());
        data.put("temperature", 0.5);
        data.put("max_tokens", 2048);
        data.put("top_p", 1);
        data.put("frequency_penalty", 0);
        data.put("presence_penalty", 0);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(data, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response;
    }

    @PostMapping("/assist")
    public ResponseEntity<String> assist(@RequestBody AssistantRequest assistantRequest) {
        return query(new GptSimpleRequest(getQuestion(assistantRequest).getBody(), "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"));
    }


    @PostMapping("/question")
    public ResponseEntity<String> getQuestion(@RequestBody AssistantRequest assistantRequest) {
        final String prompt = new AssistantRequestDto(assistantRequest).getPrompt();
        System.out.println(prompt);
        return new ResponseEntity<>(prompt, HttpStatus.OK);
    }

    @PostMapping("/awaken")
    public ResponseEntity<String> awaken() {
        return new ResponseEntity<>("Service awakened.", HttpStatus.OK);
    }
}
