package com.services.cxf.soap.services;

import com.cxf.soap.wsdl.services.person.ServiceFaultException;
import com.cxf.soap.wsdl.types.person.Person;
import com.cxf.soap.wsdl.types.person.ServiceFault;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService
{
    private Map<Person,List<Person>> personList = new HashMap<>();

    public PersonService() {
        Person person1 = new Person();
        person1.setName("Vadim");
        person1.setBirthday(1996);
        Person person2 = new Person();
        person2.setName("Misha");
        person2.setBirthday(1986);
        Person person3 = new Person();
        person3.setName("Igor");
        person3.setBirthday(1997);
        Person person4 = new Person();
        person4.setName("Nikita");
        person4.setBirthday(1996);
        Person person5 = new Person();
        person5.setName("Maxim");
        person5.setBirthday(2000);
        Person person6 = new Person();
        person6.setName("Dima");
        person6.setBirthday(1995);
        Person person7 = new Person();
        person7.setName("Nikita2");
        person7.setBirthday(1996);
        personList.put(person1, Arrays.asList(person2, person3, person4,person7));
        personList.put(person2, Arrays.asList(person6, person1));
        personList.put(person3, Arrays.asList(person4, person5));
        personList.put(person4, Arrays.asList(person1, person3, person4, person6));
        personList.put(person5, Arrays.asList(person1,person6));
        personList.put(person6, Arrays.asList(person2, person3, person4));
    }

    public List<Person> getFriends(Person person, Integer year) throws ServiceFaultException {
        try {
            return personList.get(person).stream().filter((s) -> s.getBirthday() == year).collect(Collectors.toList());
        } catch (NullPointerException n){
            ServiceFault serviceFault = new ServiceFault();
            serviceFault.setCode("NOT_FOUNT");
            serviceFault.setDescription("Friends with request year: "+year+" not found.");
            throw new ServiceFaultException("ERROR",serviceFault);
        }
    }
}