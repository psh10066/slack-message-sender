package com.psh10066.slackmessagesender;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class SlackMessageSenderTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("텍스트 블록을 생성할 수 있다.")
    @Test
    void test1() throws Exception {
        // given
        SlackMessageSender.Body body = SlackMessageSender.builder()
            .text("안녕하세요~")
            .body();

        // when
        String jsonBody = objectMapper.writeValueAsString(body);

        // then
        String expected = """
            {
                "blocks": [
                    {
                        "type":"rich_text",
                        "elements":[
                            {
                                "type":"rich_text_section",
                                "elements":[
                                    {
                                        "type":"text",
                                        "text":"안녕하세요~"
                                    }
                                ]
                            }
                        ]
                    }
                ]
            }
            """;
        JSONAssert.assertEquals(jsonBody, expected, true);
    }

    @DisplayName("텍스트 블록을 여러 개 생성할 수 있다.")
    @Test
    void test1_1() throws Exception {
        // given
        SlackMessageSender.Body body = SlackMessageSender.builder()
            .text("안녕하세요~")
            .text("반갑습니다.")
            .body();

        // when
        String jsonBody = objectMapper.writeValueAsString(body);

        // then
        String expected = """
            {
                "blocks": [
                    {
                        "type":"rich_text",
                        "elements":[
                            {
                                "type":"rich_text_section",
                                "elements":[
                                    {
                                        "type":"text",
                                        "text":"안녕하세요~"
                                    }
                                ]
                            }
                        ]
                    },
                    {
                        "type":"rich_text",
                        "elements":[
                            {
                                "type":"rich_text_section",
                                "elements":[
                                    {
                                        "type":"text",
                                        "text":"반갑습니다."
                                    }
                                ]
                            }
                        ]
                    }
                ]
            }
            """;
        JSONAssert.assertEquals(jsonBody, expected, true);
    }

    @DisplayName("이미지 블록을 생성할 수 있다.")
    @Test
    void test2() throws Exception {
        // given
        SlackMessageSender.Body body = SlackMessageSender.builder()
            .image("http://image.url")
            .body();

        // when
        String jsonBody = objectMapper.writeValueAsString(body);

        // then
        String expected = """
            {
                "blocks": [
                    {
                        "type":"image",
                        "alt_text":"",
                        "image_url":"http://image.url"
                    }
                ]
            }
            """;
        JSONAssert.assertEquals(jsonBody, expected, true);
    }

    @DisplayName("이미지 블록을 여러 개 생성할 수 있다.")
    @Test
    void test2_1() throws Exception {
        // given
        SlackMessageSender.Body body = SlackMessageSender.builder()
            .image("http://image.url")
            .image("http://image.url2")
            .body();

        // when
        String jsonBody = objectMapper.writeValueAsString(body);

        // then
        String expected = """
            {
                "blocks": [
                    {
                        "type":"image",
                        "alt_text":"",
                        "image_url":"http://image.url"
                    },
                    {
                        "type":"image",
                        "alt_text":"",
                        "image_url":"http://image.url2"
                    }
                ]
            }
            """;
        JSONAssert.assertEquals(jsonBody, expected, true);
    }

    @DisplayName("블록을 조합할 수 있다.")
    @Test
    void test3() throws Exception {
        // given
        SlackMessageSender.Body body = SlackMessageSender.builder()
            .text("안녕하세요~")
            .image("http://image.url")
            .body();

        // when
        String jsonBody = objectMapper.writeValueAsString(body);

        // then
        String expected = """
            {
                "blocks": [
                    {
                        "type":"rich_text",
                        "elements":[
                            {
                                "type":"rich_text_section",
                                "elements":[
                                    {
                                        "type":"text",
                                        "text":"안녕하세요~"
                                    }
                                ]
                            }
                        ]
                    },
                    {
                        "type":"image",
                        "alt_text":"",
                        "image_url":"http://image.url"
                    }
                ]
            }
            """;
        JSONAssert.assertEquals(jsonBody, expected, true);
    }

    @DisplayName("preformatted 블록을 생성할 수 있다.")
    @Test
    void test4() throws Exception {
        // given
        SlackMessageSender.Body body = SlackMessageSender.builder()
            .preformatted("안녕하세요~")
            .body();

        // when
        String jsonBody = objectMapper.writeValueAsString(body);

        // then
        String expected = """
            {
                "blocks": [
                    {
                        "type":"rich_text",
                        "elements":[
                            {
                                "type":"rich_text_preformatted",
                                "elements":[
                                    {
                                        "type":"text",
                                        "text":"안녕하세요~"
                                    }
                                ]
                            }
                        ]
                    }
                ]
            }
            """;
        JSONAssert.assertEquals(jsonBody, expected, true);
    }

    @DisplayName("quote 블록을 생성할 수 있다.")
    @Test
    void test5() throws Exception {
        // given
        SlackMessageSender.Body body = SlackMessageSender.builder()
            .quote("안녕하세요~")
            .body();

        // when
        String jsonBody = objectMapper.writeValueAsString(body);

        // then
        String expected = """
            {
                "blocks": [
                    {
                        "type":"rich_text",
                        "elements":[
                            {
                                "type":"rich_text_quote",
                                "elements":[
                                    {
                                        "type":"text",
                                        "text":"안녕하세요~"
                                    }
                                ]
                            }
                        ]
                    }
                ]
            }
            """;
        JSONAssert.assertEquals(jsonBody, expected, true);
    }
}