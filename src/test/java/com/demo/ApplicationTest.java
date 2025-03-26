package com.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    @Test
    public void testGetGreeting() {
        Application app = new Application();
        assertEquals("Hello, World!", app.getGreeting());
    }
}
