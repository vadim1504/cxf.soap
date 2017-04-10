package com.services.cxf.soap.endpoint;

import javax.xml.ws.Endpoint;

import com.services.cxf.soap.services.PersonService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(PersonImpl personImpl) {
        EndpointImpl endpoint = new EndpointImpl(bus, personImpl);
        endpoint.publish("/person");
        return endpoint;
    }

    @Bean
    public PersonService personService(){
        return new PersonService();
    }

    @Bean
    public PersonImpl personImpl(){
        return new PersonImpl();
    }
}