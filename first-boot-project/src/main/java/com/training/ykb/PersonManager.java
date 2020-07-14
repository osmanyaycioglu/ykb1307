package com.training.ykb;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class PersonManager {

    private final Map<String, Person> personMap = new ConcurrentHashMap<>();

    public void addPerson(final Person personParam) {
        personParam.setId(UUID.randomUUID()
                              .toString());
        this.personMap.put(personParam.getId(),
                           personParam);
    }

    public void updatePerson(final Person personParam) {
        this.personMap.put(personParam.getId(),
                           personParam);
    }

    public void deletePerson(final String uid) {
        this.personMap.remove(uid);
    }

    public Person getPerson(final String uid) {
        return this.personMap.get(uid);
    }

    public Collection<Person> getAll() {
        return this.personMap.values();
    }

}
