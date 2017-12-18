package com.boot.controller;

import com.boot.service.PersonListRepository;
import com.boot.config.AuthorSettings;
import com.boot.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuzm on 2017/12/4.
 */
@Controller
public class PersonController {
    @Autowired
    private AuthorSettings authorSettings;

    private PersonListRepository personListRepository;
    @Autowired
    PersonController(PersonListRepository personListRepository) {
        this.personListRepository = personListRepository;
    }
    @RequestMapping("/")
    public String index(Model model) {
        //return "author name is " + authorSettings.getName() + " and age is " + authorSettings.getAge();
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("xx", 11);
        Person p2 = new Person("yy", 22);
        Person p3 = new Person("zz", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index1";
    }

    @RequestMapping(value = "/api/{name}", method = RequestMethod.GET)
    public String findByName(@PathVariable("name")String name, Model model) {
        List<Person> persons = personListRepository.findByName(name);
        if (persons != null) {
            model.addAttribute("persons", persons);
        }
        return "personList";
    }
    @RequestMapping(value="/api/{name}", method=RequestMethod.POST)
    public String addToReadingList(Person person) {
        personListRepository.save(person);
        return "redirect:/{name}";
    }
}
