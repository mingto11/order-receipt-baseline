package org.katas.refactoring;

public class Customer {

    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String toString(){
        StringBuilder customerInformation = new StringBuilder();
        return customerInformation
                .append(name)
                .append(address)
                .toString();
    }
}
