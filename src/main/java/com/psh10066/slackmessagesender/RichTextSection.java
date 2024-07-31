package com.psh10066.slackmessagesender;

import lombok.Getter;

import java.util.List;

@Getter
class RichTextSection extends RichTextObject {

    private final List<RichTextElement> elements;

    private RichTextSection(RichTextElement... richTextElements) {
        super("rich_text_section");
        this.elements = List.of(richTextElements);
    }

    static RichTextSection text(String text) {
        return new RichTextSection(new RichTextElement.Text(text));
    }
}
