package com.demo;

public class Application {
    public String getGreeting() {
        return "Hello, World!";
    }

    public static void main(String[] args) {
        Application app = new Application();
        System.out.println(app.getGreeting());
    }
}
