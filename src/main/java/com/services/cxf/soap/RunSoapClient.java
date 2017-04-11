package com.services.cxf.soap;

import com.cxf.soap.wsdl.services.person.*;
import com.cxf.soap.wsdl.services.person.ServiceFault;
import com.cxf.soap.wsdl.types.person.*;
import com.cxf.soap.wsdl.types.person.Person;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class RunSoapClient {

    public static void main(String[] args){

        String serviceUrl = "http://localhost:9090/cxf/soap/person";
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(PersonPortType.class);
        factory.setAddress(serviceUrl);
        PersonPortType personImpl = (PersonPortType) factory.create();

        Person person = new Person();
        person.setName("Vadim");
        person.setBirthday(1996);

        ObjectFactory factory2 = new ObjectFactory();
        Request request = factory2.createRequest();

        request.setPerson(person);
        request.setYear(1996);

        Response response = null;
        try {
            response = personImpl.getFriends(request);
            response.getFriends().forEach(System.out::println);
        } catch (ServiceFaultException e) {
            System.out.printf("Code: "+e.getFaultInfo().getCode()+"; Description: "+e.getFaultInfo().getDescription());
        }


    }
}
