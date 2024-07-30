package com.psh10066.slackmessagesender;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
abstract class RichTextObject {

    private final String type;
}
