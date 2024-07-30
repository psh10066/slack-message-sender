package com.psh10066.slackmessagesender;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
abstract class RichTextElement {

    private final String type;

    @Getter
    static class Text extends RichTextElement {

        private final String text;

        public Text(String text) {
            super("text");
            this.text = text;
        }
    }
}
