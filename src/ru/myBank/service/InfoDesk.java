package ru.myBank.service;

import ru.myBank.model.Discount;
import ru.myBank.model.LowPercent;
import ru.myBank.model.PotokPrimer;

public class InfoDesk { //стойка информации

    private String ticket;
    private String uslugaType;


    public InfoDesk(String ticket, String uslugaType) {
        this.ticket = ticket;
        this.uslugaType = uslugaType;
    }

    public static void main(String[] args) {

        BankService t = new BankService("");
        // t.start();

        LowPercent commonResource = new LowPercent();
        for (int i = 1; i < 4; i++) {
            Thread th = new Thread(new PotokPrimer(commonResource));
            th.setName("Попытка " + i);
            th.start();


        }

    }
}







