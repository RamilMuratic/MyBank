package ru.myBank.model;

public class Client {

    private int clientId;
    private String passportNumber;
    private String fio;
    private int cardNumber;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Client(String fio, int clientId, String passportNumber, int cardNumber) {
        this.fio = fio;
        this.clientId = clientId;
        this.passportNumber = passportNumber;
        this.cardNumber = cardNumber;
    }
    public Client() {

    }
}

