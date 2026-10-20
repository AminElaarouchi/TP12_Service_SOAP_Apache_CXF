package com.acme.cxf.client;

import com.acme.cxf.api.HelloService;
import jakarta.xml.ws.Service;
import javax.xml.namespace.QName;
import java.net.URL;

public class ClientDemo {
    public static void main(String[] args) throws Exception {
        URL wsdl = new URL("http://localhost:8080/services/hello?wsdl");
        QName name = new QName("http://api.cxf.acme.com/", "HelloService");
        HelloService port = Service.create(wsdl, name).getPort(HelloService.class);
        System.out.println(port.sayHello("ClientJava"));
        System.out.println(port.findPersonById("P-777").getName());
    }
}
