package com.calderon.clientews.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class SoapClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public Object callWebService(Object request) {
        return webServiceTemplate.marshalSendAndReceive(request);
    }
}