package com.github.curriculeon.controller;

import com.github.curriculeon.model.AssistantRequest;
import com.github.curriculeon.model.gpt.request.GptSimpleRequest;
import com.github.curriculeon.service.GptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/gpt")
public class GptController {
    private GptService gptService;

    @Autowired
    public GptController(GptService gptService) {
        this.gptService = gptService;
    }

    @PostMapping("/query")
    public ResponseEntity<String> query(
            @RequestBody GptSimpleRequest requestObject) {
        return gptService.query(requestObject.getPrompt(), requestObject.getToken());
    }

    @PostMapping("/assist")
    public ResponseEntity<String> assist(@RequestBody AssistantRequest assistantRequest) {
        return gptService.assist(assistantRequest);
    }


    @PostMapping("/question")
    public ResponseEntity<String> getQuestion(@RequestBody AssistantRequest assistantRequest) {
        return gptService.getQuestion(assistantRequest);
    }

    @PostMapping("/awaken")
    public ResponseEntity<String> awaken() {
        return new ResponseEntity<>("Service awakened.", HttpStatus.OK);
    }
}
