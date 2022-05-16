package ru.myBank.service;

public class InfoDesk { //стойка информации

    private String ticket;
    private String uslugaType;


    public InfoDesk(String ticket, String uslugaType) {
        this.ticket = ticket;
        this.uslugaType = uslugaType;
    }

    public static void main(String[] args) {

        BankService t= new BankService("Поток");
        t.start();
        System.out.println(t.getName());


    }


}







