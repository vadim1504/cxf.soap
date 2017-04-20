package com.services.cxf.soap;

import com.cxf.soap.wsdl.services.person.ServiceFaultException;
import com.cxf.soap.wsdl.types.person.Person;
import com.services.cxf.soap.client.PersonClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class RunSoapClient {

    public static void main(String[] args){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com/services/cxf/soap/client");

        PersonClient personClient = annotationConfigApplicationContext.getBean(PersonClient.class);

        Person person = new Person();
        person.setName("Vadim");
        person.setBirthday(1996);

        List<Person> people = null;
        try {
            people = personClient.getFriends(person,1997);
        } catch (ServiceFaultException e) {
            e.printStackTrace();
        }

        people.forEach(System.out::println);
    }
}
