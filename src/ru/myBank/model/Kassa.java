package ru.myBank.model;
import ru.myBank.service.InfoDesk;

import java.util.ArrayList;
import java.util.List;

public class Kassa extends InfoDesk {

    private final CashReceipt CASH_RECEIPT_1 = new CashReceipt("2222", 1212, "11/05/22");
    private final CashReceipt CASH_RECEIPT_2 = new CashReceipt("1111", 2222, "12/05/22");
    private final CashReceipt CASH_RECEIPT_3 = new CashReceipt("3333", 3232, "11/05/22");
    private final CashReceipt CASH_RECEIPT_4 = new CashReceipt("4444", 4242, "17/05/22");
    private final CashReceipt CASH_RECEIPT_5 = new CashReceipt("5555", 5252, "12/05/22");

    public List<CashReceipt> cashReceipts = List.of(CASH_RECEIPT_1, CASH_RECEIPT_2, CASH_RECEIPT_3, CASH_RECEIPT_4, CASH_RECEIPT_5);

    public Kassa(String ticket, String uslugaType) {
        super(ticket, uslugaType);
    }

/*    private List<CashReceipt> chekOnData = new ArrayList<>();

    public List<CashReceipt> getCashReceipts(int cardHolderNumber) { //Получаем чек по номеру карточки
        return cashReceipts;
    }

    public CashReceipt giveMeCashReceiptOnDate(String date1) {
        for (CashReceipt currentChek : cashReceipts) {
            if (currentChek != null && currentChek.getDateOfOperation().equals(date1))
                chekOnData.add(currentChek);
        }
        return null;
    }

    public List<CashReceipt> getChekOnData() {
        return chekOnData;
    }*/
}
