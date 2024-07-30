package com.psh10066.slackmessagesender;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
abstract class Block {

    private final String type;
}
