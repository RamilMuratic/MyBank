package ru.myBank.service;

import ru.myBank.model.ATM;
import ru.myBank.model.CashReceipt;
import ru.myBank.model.Kassa;

//import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InfoDesk { //стойка информации

    private String ticket;
    private String uslugaType;

    public InfoDesk(String ticket, String uslugaType) {
        this.ticket = ticket;
        this.uslugaType = uslugaType;
    }

    public static void main(String[] args) {

        BankService bankService = new BankService();
        Kassa kassa = new Kassa();
        ATM atm = new ATM();

     /*   String data = "11/05/22";
        kassa.giveMeCashReceiptOnDate(data);
        //System.out.println("Chek on date " + data + ":");
        process(kassa.getChekOnData());*/

    /*    String [] newArray = bankService.getArrayServices();
        for (int i = 0; i < 5; i++)
            System.out.println(newArray[i]);

        int a = 0;

        while (newArray.length > a) {
            System.out.println(newArray[a]);
            a++;
        }
        for (String s : newArray) {
            System.out.println(s);
        }
        int i = newArray.length - 1;
        do {
            System.out.println(newArray[i]);
            i--;
        }
        while (i >= 0);*/
        Map<String,ATM> map = new HashMap<>();   //пример реализации Мар'а со связью ключ-Мар

        populateMap(map);

       ATM a = map.get("Вин-код производителя: 1532");
        System.out.println(a.toString());
    }

    private static void populateMap(Map<String, ATM> myMap) {
        myMap.put("Вин-код производителя: 1532", new ATM("Банкомат для приема платежей", 123, "г.Москва, ул.Садовая, 12"));
        myMap.put("Вин-код производителя: 3151", new ATM("Банкомат для получения денег", 42, "г.Казань, ул.Менделеева, 112"));
        myMap.put("Вин-код производителя: 6166", new ATM("Банкомат для оплаты жкх", 17, "г.Уфа, ул.К.Маркса, 1"));
    }

    public String getTicket() {
        return ticket;
    }

    public String getUslugaType() {
        return uslugaType;
    }

   /* private static void process(List<CashReceipt> chekOnData) {
        while (chekOnData.size() > 0) {
            CashReceipt cR = chekOnData.get(0);
            System.out.println(cR);
            chekOnData.remove(cR);
        }
    }*/
}







