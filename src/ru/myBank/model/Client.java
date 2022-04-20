package ru.myBank.model;

public class Client {


    private int clientId;
    private String passportNumber;
    private String fio;
    private int cardHolderNumber;

    public Client(int clientId, String passportNumber, String fio, int cardHolderNumber) {
        this.fio = fio;
        this.clientId = clientId;
        this.passportNumber = passportNumber;
        this.cardHolderNumber = cardHolderNumber;
    }


}

