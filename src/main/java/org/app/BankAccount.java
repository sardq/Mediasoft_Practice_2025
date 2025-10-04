package org.app;

import  java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Random;

public class BankAccount {
    private String name;
    private int balance;
    private final LocalDateTime openingDate;
    private boolean isBlocked;
    private String number;
    public
    BankAccount(String name) {
        this.name = name;
        this.balance = 0;
        this.openingDate = LocalDateTime.now();
        this.isBlocked = false;
        this.number = "";
        Random random = new Random();
        for (int i = 0; i < 8; i++)
        {
            this.number = this.number.concat(String.valueOf(random.nextInt(0,9)));
        }
    }

    public boolean deposit(int amount) {
        this.balance += amount;
       return  true;
    }
    public boolean withdraw(int amount) {
        if (this.balance > amount){
            this.balance -= amount;
            return  true;
        }
            return  false;
    }
    public boolean transfer(BankAccount otherAccount, int amount){
        if (this.balance > amount) {
            this.balance -= amount;
            otherAccount.deposit(amount);
            return true;
        }
        return  false;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Имя: '" + this.name +
                "', Баланс: '" + this.balance +
                "', Дата открытия счета: '" + this.openingDate.format(formatter) +
                "', Заблокирован ли счет: '" + this.isBlocked +
                "', Номер счета: '" + this.number + "'  ";
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        BankAccount otherAccount = (BankAccount) obj;
        return Objects.equals(this.name, otherAccount.name)
                && this.balance == otherAccount.balance
                && this.isBlocked == otherAccount.isBlocked
                && this.openingDate == otherAccount.openingDate
                && Objects.equals(this.number, otherAccount.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, isBlocked, openingDate, number);
    }
}
