package ru.myBank.service;

import ru.myBank.model.Client;

public class BankService {

    private String[] arrayServices = {"Ритейл", "Фондовые услуги", "Пенсионные услуги", "Ипотечные услуги", "Кредитование"};

    public String[] getArrayServices() {
        return arrayServices;
    }

    private Client Client1 = new Client(1, "92154785", "Вася", 1212);
    private Client Client2 = new Client(2, "45635463", "Федя", 2222);
    private Client Client3 = new Client(13, "69868688", "Коля", 3232);
    private Client Client4 = new Client(11, "85388883", "Маша", 4242);
    private Client Client5 = new Client(6, "22282828", "Миша", 5252);


}
