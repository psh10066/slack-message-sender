package com.psh10066.slackmessagesender;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

@Getter
class RichTextBlock extends Block {

    private final List<RichTextObject> elements = new LinkedList<>();

    public RichTextBlock() {
        super("rich_text");
    }

    public void add(RichTextObject element) {
        elements.add(element);
    }
}