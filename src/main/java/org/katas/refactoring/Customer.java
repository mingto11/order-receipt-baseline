package org.katas.refactoring;

public class Customer {

    private String name;
    private String address;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString(){
        StringBuilder customerInformation = new StringBuilder();
        customerInformation.append(name);
        customerInformation.append(address);
        return customerInformation.toString();
    }
}
