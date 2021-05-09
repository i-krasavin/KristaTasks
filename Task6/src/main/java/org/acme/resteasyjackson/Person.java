package org.acme.resteasyjackson;

public class Person {
    public String name;
    public String[] numbers;
    public Address address;
    private Boolean mock = true;
    public Person (String name, String[] numbers, Address address){
        this.name = name;
        this.numbers = numbers;
        this.address = address;
    }

    public Integer getNumber() {
        if (this.mock) {
            return this.mockNumber();
        }
//        return this.numbers;
        return null;
    }

    private Integer mockNumber() {
        return 1 + (int)(Math.random() * 500);
    }

}

