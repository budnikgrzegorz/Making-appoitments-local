package com.example.lenovo.myapplication.model;

public class Person {
    private int id;
    private String name;
    private String surname;
    private String adress;
    private String code;
    private String login;
    private String password;
    private String email;
    private String telephone;

    public Person(int id, String name, String surname, String adress, String code, String login, String password, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.code = code;
        this.login = login;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
    }
}
