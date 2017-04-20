package com.services.cxf.soap.client;

import com.cxf.soap.wsdl.services.person.PersonPortType;
import com.cxf.soap.wsdl.services.person.ServiceFaultException;
import com.cxf.soap.wsdl.types.person.ObjectFactory;
import com.cxf.soap.wsdl.types.person.Person;
import com.cxf.soap.wsdl.types.person.Request;
import com.cxf.soap.wsdl.types.person.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonClient {

    @Autowired
    private PersonPortType ClientProxyBean;

    public List<Person> getFriends(Person person, int year) throws ServiceFaultException {

        ObjectFactory factory = new ObjectFactory();
        Request request = factory.createRequest();

        request.setPerson(person);
        request.setYear(year);

        Response response = ClientProxyBean.getFriends(request);

        return response.getFriends();
    }
}
