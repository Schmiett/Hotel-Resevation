package model;

import java.util.regex.Pattern;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;

    private final String emailRegex = "^(.+)@(.+).(.+)$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email){
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Error, Not a Valid Email");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getEmail(){
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString(){
        return "Welcome " + firstName + " " + lastName + " Email Address:" + email;
    }
}
