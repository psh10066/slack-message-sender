package com.psh10066.slackmessagesender;

import lombok.Getter;

@Getter
class ImageBlock extends Block {
    private final String alt_text;
    private final String image_url;

    private ImageBlock(String alt_text, String image_url) {
        super("image");
        this.alt_text = alt_text;
        this.image_url = image_url;
    }

    static ImageBlock of(String image_url) {
        return new ImageBlock("", image_url);
    }
}