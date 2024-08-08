package com.psh10066.slackmessagesender;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
abstract class RichTextObject {

    private final String type;
    private List<RichTextElement> elements;

    <T extends RichTextObject> T text(String text) {
        this.elements = List.of(new RichTextElement.Text(text));
        return (T) this;
    }

    static class RichTextSection extends RichTextObject {
        public RichTextSection() {
            super("rich_text_section");
        }
    }

    static class RichTextPreformatted extends RichTextObject {
        public RichTextPreformatted() {
            super("rich_text_preformatted");
        }
    }

    static class RichTextQuote extends RichTextObject {
        public RichTextQuote() {
            super("rich_text_quote");
        }
    }
}
