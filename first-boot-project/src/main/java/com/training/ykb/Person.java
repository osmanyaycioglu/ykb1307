package com.training.ykb;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Null;

public class Person {

    @Null
    private String id;
    @NotEmpty(message = "Name boş olamaz.")
    private String name;
    @NotEmpty
    // @NotNull
    // @NotBlank
    private String surname;
    @Min(value = 10, message = "Yaş Minimum 10 olabilir.")
    @Max(120)
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
