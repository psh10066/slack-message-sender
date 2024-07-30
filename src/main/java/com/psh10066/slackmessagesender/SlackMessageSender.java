package com.psh10066.slackmessagesender;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SlackMessageSender {

    public static UrlBuilder builder() {
        return new UrlBuilder();
    }

    public static class UrlBuilder {
        public MessageBuilder url(String url) {
            return new MessageBuilder(url);
        }
    }

    @RequiredArgsConstructor
    public static class MessageBuilder {
        private final String url;
        private final List<Block> blocks = new LinkedList<>();

        public MessageBuilder text(String text) {
            RichTextSection richTextSection = new RichTextSection();
            richTextSection.add(new RichTextElement.Text(text));

            RichTextBlock richTextBlock = new RichTextBlock();
            richTextBlock.add(richTextSection);

            this.blocks.add(richTextBlock);
            return this;
        }

        public MessageBuilder image(String imageUrl) {
            this.blocks.add(ImageBlock.of(imageUrl));
            return this;
        }

        public void send() {
            Body body = new Body(blocks);
            new RestTemplate().postForEntity(url, body, String.class);
        }
    }

    public record Body(
        List<Block> blocks
    ) {
    }
}
