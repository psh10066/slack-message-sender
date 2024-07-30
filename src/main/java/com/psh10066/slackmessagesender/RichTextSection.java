package com.psh10066.slackmessagesender;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
class RichTextSection extends RichTextObject {

    private final List<RichTextElement> elements = new LinkedList<>();

    public RichTextSection() {
        super("rich_text_section");
    }

    public void add(RichTextElement element) {
        elements.add(element);
    }
}
