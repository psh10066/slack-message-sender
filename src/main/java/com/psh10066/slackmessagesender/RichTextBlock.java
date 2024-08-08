package com.psh10066.slackmessagesender;

import lombok.Getter;

import java.util.List;

@Getter
class RichTextBlock extends Block {

    private final List<RichTextObject> elements;

    private RichTextBlock(RichTextObject... richTextObjects) {
        super("rich_text");
        this.elements = List.of(richTextObjects);
    }

    static RichTextBlock text(RichTextObject richTextObject, String text) {
        return new RichTextBlock(richTextObject.text(text));
    }
}