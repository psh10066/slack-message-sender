package com.psh10066.slackmessagesender;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SlackMessageSender {

    private final List<Block> blocks = new LinkedList<>();

    public static SlackMessageSender builder() {
        return new SlackMessageSender();
    }

    public SlackMessageSender text(String text) {
        this.blocks.add(RichTextBlock.text(new RichTextObject.RichTextSection(), text));
        return this;
    }

    public SlackMessageSender image(String imageUrl) {
        this.blocks.add(ImageBlock.of(imageUrl));
        return this;
    }

    public Body body() {
        return new Body(blocks);
    }

    public void send(String url) {
        new RestTemplate().postForLocation(url, body());
    }

    public record Body(
        List<Block> blocks
    ) {
    }
}
