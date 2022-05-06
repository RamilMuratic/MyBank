package ru.myBank.model;


import java.util.Objects;

public class ATM {

    private String bankomatType;
    private int bankomatNumber;
    private String bankomatLocation;

    public ATM(String bankomatType, int bankomatNumber, String bankomatLocation) {
        this.bankomatNumber = bankomatNumber;
        this.bankomatLocation = bankomatLocation;
        this.bankomatType = bankomatType;

    }
    public ATM() {

    }

    public String getBankomatType() {
        return bankomatType;
    }

    public int getBankomatNumber() {
        return bankomatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ATM atm = (ATM) o;
        return Objects.equals(bankomatType, atm.bankomatType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankomatType);
    }

    @Override
    public String toString() {
        return "ATM{" +
                "bankomatType='" + bankomatType + '\'' +
                ", bankomatNumber=" + bankomatNumber +
                ", bankomatLocation='" + bankomatLocation + '\'' +
                '}';
    }


}
