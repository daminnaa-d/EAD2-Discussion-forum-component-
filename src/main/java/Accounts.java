package org.example.model;

import beans.UserBean;

import java.util.ArrayList;

public class Accounts {
    private static Accounts accounts;
    private ArrayList<UserBean> users = new ArrayList<>();

    private Accounts(){};

    public static Accounts getAccounts() {
        if (accounts == null) {
            accounts = new Accounts();
        }
        return accounts;
    }

    public ArrayList<UserBean> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserBean> users) {
        this.users = users;
    }
}
