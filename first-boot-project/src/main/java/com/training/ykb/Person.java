package com.training.ykb;


public class Person {

    private String id;
    private String name;
    private String surname;
    private int    age;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int ageParam) {
        this.age = ageParam;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String idParam) {
        this.id = idParam;
    }


}
