package com.services.cxf.soap.endpoint;

import com.cxf.soap.wsdl.types.person.Person;
import com.cxf.soap.wsdl.services.person.PersonPortType;
import com.cxf.soap.wsdl.types.person.ObjectFactory;
import com.cxf.soap.wsdl.types.person.Request;
import com.cxf.soap.wsdl.types.person.Response;
import com.services.cxf.soap.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonImpl implements PersonPortType {

    @Autowired
    private PersonService personService;

    @Override
    public Response getFriends(Request request) {

        List<Person> personList = personService.getFriends(request.getPerson(),request.getYear());

        ObjectFactory objectFactory = new ObjectFactory();
        Response response = objectFactory.createResponse();

        response.getFriends().addAll(personList);

        return response;
    }
}