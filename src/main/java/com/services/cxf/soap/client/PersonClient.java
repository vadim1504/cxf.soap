package com.services.cxf.soap.client;

import com.cxf.soap.wsdl.services.person.PersonPortType;
import com.cxf.soap.wsdl.services.person.ServiceFault;
import com.cxf.soap.wsdl.services.person.ServiceFaultException;
import com.cxf.soap.wsdl.types.person.ObjectFactory;
import com.cxf.soap.wsdl.types.person.Person;
import com.cxf.soap.wsdl.types.person.Request;
import com.cxf.soap.wsdl.types.person.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonClient {

    @Autowired
    private PersonPortType ClientProxyBean;

    public String getFriends(Person person, int year) throws ServiceFaultException {

        ObjectFactory factory = new ObjectFactory();
        Request request = factory.createRequest();

        request.setPerson(person);
        request.setYear(year);

        Response response = ClientProxyBean.getFriends(request);

        StringBuilder result = new StringBuilder();
        response.getFriends().forEach(result::append);

        return result.toString();
    }
}