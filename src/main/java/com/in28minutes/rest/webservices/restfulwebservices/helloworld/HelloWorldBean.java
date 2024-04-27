package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
    private String messageForYou;

    public HelloWorldBean(String messageForYou) {
        this.messageForYou = messageForYou;
    }

    // Getter
    public String getMessage() {
        return messageForYou;
    }

    // Setter
    public void setMessage(String messageForYou) {
        this.messageForYou = messageForYou;
    }
}
