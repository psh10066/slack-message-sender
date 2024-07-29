package com.psh10066.slackmessagesender;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SlackMessageSender {

    public static UrlBuilder builder() {
        return new UrlBuilder();
    }

    public static class UrlBuilder {
        public TextBuilder url(String url) {
            return new TextBuilder(url);
        }
    }

    @RequiredArgsConstructor
    public static class TextBuilder {
        private final String url;

        public BodyBuilder text(String text) {
            return new BodyBuilder(url, text);
        }
    }

    @RequiredArgsConstructor
    public static class BodyBuilder {
        private final String url;
        private final String text;

        public void send() {
            new RestTemplate().postForEntity(url, new Body(text), String.class);
        }
    }

    public record Body(
        String text
    ) {
    }
}
