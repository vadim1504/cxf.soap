package com.services.cxf.soap.client;

import com.cxf.soap.wsdl.services.person.PersonPortType;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ClientConfig {

    @Value("${service.address}")
    private String serviceAddress;

    @Bean(name = "ClientProxyBean")
    public PersonPortType opportunityPortType() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setServiceClass(PersonPortType.class);
        jaxWsProxyFactoryBean.setAddress(serviceAddress);
        return (PersonPortType) jaxWsProxyFactoryBean.create();
    }

}