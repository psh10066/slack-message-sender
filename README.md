# Slack 메시지 발송 라이브러리

## 프로젝트 개요

- Slack 메시지 연동 시 메시지 포맷에 맞춰 코드를 작성하는 번거로움을 해소하기 위한 라이브러리.
- 메시지 양식 객체를 가져올 수도 있고, Incoming Webhook URL을 통해 직접 메시지를 발송할 수도 있다.

## 사용 방법

- `SlackMessageSender.builder()` 이후 아래 메소드를 사용하여 메시지를 조합합니다.
  - text : 일반 텍스트
  - image : 이미지 URL
  - preformatted : 텍스트 블록
  - quote : 인용 블록

### 1. 메시지 양식 가져오기

```java
SlackMessageSender.Body body = SlackMessageSender.builder()
    .text("텍스트입니다.")
    .image("http://image.url")
    .preformatted("텍스트 블록입니다.")
    .quote("인용 블록입니다.")
    .body();
```

### 2. 직접 메시지 보내기

- 선제 조건 : Slack Incoming Webhook을 활성화하여 Webhook URL을 가지고 있어야 합니다. 
  - https://api.slack.com/messaging/webhooks

```java
SlackMessageSender.builder()
    .text("텍스트입니다.")
    .image("http://image.url")
    .preformatted("텍스트 블록입니다.")
    .quote("인용 블록입니다.")
    .send("https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX");
```

## 설치 방법

- build.gradle에 아래 코드 추가

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.psh10066:slack-message-sender:v0.0.4'
}
```