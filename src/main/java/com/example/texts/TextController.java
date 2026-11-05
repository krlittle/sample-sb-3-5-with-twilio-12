package com.example.texts;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {

    private final TextService texts;

    public TextController(TextService texts) {
        this.texts = texts;
    }

    @PostMapping("/texts")
    public String send(@RequestParam String to, @RequestParam String body) {
        return texts.send(to, body);
    }
}
