package com.github.ismail2ov;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

class HelpfulNullPointerExceptionsTest {

    @Test
    void testHelpfulNullPointerExceptions() {

        House house = new House();

        Person person = new Person();
        person.setHouse(house);

        Throwable thrown = catchThrowable(() -> {
            String personZipCode = person.getHouse().getAddress().getZipCode();
        });

        assertThat(thrown)
            .isInstanceOf(NullPointerException.class)
            .hasMessageEndingWith("because the return value of \"com.github.ismail2ov.House.getAddress()\" is null");
    }


}

class Person {

    private House house;

    public void setHouse(House house) {
        this.house = house;
    }

    public House getHouse() {
        return this.house;
    }
}

class House {

    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }
}

class Address {

    private String name;
    private String zipCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}


