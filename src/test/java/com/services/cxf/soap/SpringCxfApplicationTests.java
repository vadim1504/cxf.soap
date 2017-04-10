package com.services.cxf.soap;

import static org.assertj.core.api.Assertions.assertThat;

import com.cxf.soap.wsdl.types.person.Person;
import com.services.cxf.soap.client.PersonClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringCxfApplicationTests {

    @Autowired
    private PersonClient personClient;

    @Test
    public void testSayHello() {
        Person person = new Person();
        person.setName("Vadim");
        person.setBirthday(1996);
        assertThat(personClient.getFriends(person, 1997)).isEqualTo("Person{name=Igor, birthday=1997}");
        assertThat(personClient.getFriends(person, 1996)).isEqualTo("Person{name=Nikita, birthday=1996}Person{name=Nikita2, birthday=1996}");
    }
}