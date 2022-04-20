package ru.myBank.model;

public class CashReceipt {//чек

    private String cashReceiptNumber;
    private int cardHolderNumber;
    private String dateOfOperation;


    public CashReceipt(String cashReceiptNumber, int cardHolderNumber, String dateOfOperation) {
        this.cardHolderNumber = cardHolderNumber;
        this.cashReceiptNumber = cashReceiptNumber;
        this.dateOfOperation = dateOfOperation;
    }

    public String getCashReceiptNumber() {
        return cashReceiptNumber;
    }

    public int getCardHolderNumber() {
        return cardHolderNumber;
    }

    public String getDateOfOperation() {
        return dateOfOperation;
    }

    @Override
    public String toString() {
        return "ru.myBank.model.CashReceipt{" +
                "cashReceiptNumber='" + cashReceiptNumber + '\'' +
                ", cardHolderNumber=" + cardHolderNumber +
                ", dateOfOperation='" + dateOfOperation + '\'' +
                '}';
    }
}
