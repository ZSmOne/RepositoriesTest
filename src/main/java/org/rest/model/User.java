package org.rest.model;

import org.rest.repository.impl.UserToBankRepositoryImpl;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private City city;
    private List<Bank> bankList;
    private static final UserToBankRepositoryImpl userToBankRepository = UserToBankRepositoryImpl.getInstance();

    public User() {
    }

    public User(Long id, String name, City city, List<Bank> bankList) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.bankList = bankList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

//    public List<Bank> getBankList() {
//        return bankList;
//    }
    public List<Bank> getBankList() {
        if (bankList == null) {
            //bankList = userToBankRepository.findBanksByUserId(this.id);
        }
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }
}
