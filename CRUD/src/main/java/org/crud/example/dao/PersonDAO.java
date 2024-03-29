package org.crud.example.dao;


import java.util.ArrayList;
import java.util.List;
import org.crud.example.models.Person;
import org.springframework.stereotype.Component;


@Component
public class PersonDAO {

  private static int PEOPLE_COUNT;

  private List<Person> people;

  {
    people = new ArrayList<>();
    people.add(new Person(PEOPLE_COUNT++, "Tom", 24, "tom@mail.ru"));
    people.add(new Person(PEOPLE_COUNT++, "Bob", 52, "bob@mail.ru"));
    people.add(new Person(PEOPLE_COUNT++, "Mike", 18, "mike@mail.ru"));
    people.add(new Person(PEOPLE_COUNT++, "Katy", 34, "katy@mail.ru"));
  }


  public List<Person> index() {
    return people;
  }

  public Person show(int id) {
    return people.stream()
        .filter(person -> person.getId() == id)
        .findAny()
        .orElse(null);
  }

  public void save(Person person) {
    person.setId(PEOPLE_COUNT++);
    people.add(person);
  }

  public void update(int id, Person person) {
    Person personToBeUpdated = show(id);

    personToBeUpdated.setName(person.getName());
    personToBeUpdated.setAge(person.getAge());
    personToBeUpdated.setEmail(person.getEmail());
  }

  public void delete(int id) {
    people.removeIf(person -> person.getId() == id);
  }

}
