package ru.myBank.databases;

import java.io.File;

public class BankOperationsDb {
    private File file;

    private static BankOperationsDb bodb;

    private BankOperationsDb() {

        file = new File("1.txt");
    }

    public static BankOperationsDb getInstance() {
        if (bodb == null) {
            bodb = new BankOperationsDb();
        }
        return bodb;
    }
}
