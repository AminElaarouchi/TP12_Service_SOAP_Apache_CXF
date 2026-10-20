package com.acme.cxf;

import com.acme.cxf.impl.HelloServiceImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HelloServiceTest {
    private final HelloServiceImpl service = new HelloServiceImpl();
    @Test void greetingAndPerson() {
        assertEquals("Bonjour, Karim", service.sayHello("Karim"));
        assertEquals("Bonjour, inconnu", service.sayHello(null));
        assertEquals("Ada Lovelace", service.findPersonById("P-777").getName());
    }
}
