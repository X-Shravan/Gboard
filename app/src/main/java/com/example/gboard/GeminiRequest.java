package com.example.gboard;

import java.util.Collections;
import java.util.List;

public class GeminiRequest {
    private List<Content> contents;

    public GeminiRequest(String prompt) {
        this.contents = Collections.singletonList(new Content(prompt));
    }

    public List<Content> getContents() {
        return contents;
    }

    public static class Content {
        private List<Part> parts;

        public Content(String text) {
            this.parts = Collections.singletonList(new Part(text));
        }

        public List<Part> getParts() {
            return parts;
        }
    }

    public static class Part {
        private String text;

        public Part(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
