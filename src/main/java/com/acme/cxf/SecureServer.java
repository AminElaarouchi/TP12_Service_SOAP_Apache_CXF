package com.acme.cxf;

import com.acme.cxf.impl.HelloServiceImpl;
import com.acme.cxf.security.UTPasswordCallback;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import java.util.HashMap;
import java.util.Map;

public class SecureServer {
    public static void main(String[] args) {
        String password = System.getenv().getOrDefault("SOAP_DEMO_PASSWORD", "secret123");
        Map<String, Object> security = new HashMap<>();
        security.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        security.put(WSHandlerConstants.PASSWORD_TYPE, "PasswordText");
        security.put(WSHandlerConstants.PW_CALLBACK_REF, new UTPasswordCallback(Map.of("student", password)));
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(HelloServiceImpl.class);
        factory.setAddress("http://localhost:8080/services/hello-secure");
        factory.getInInterceptors().add(new WSS4JInInterceptor(security));
        factory.create();
        System.out.println("Secure WSDL: http://localhost:8080/services/hello-secure?wsdl");
    }
}
