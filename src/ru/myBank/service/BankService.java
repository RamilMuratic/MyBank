package ru.myBank.service;

import ru.myBank.model.Client;
import ru.myBank.model.Discount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BankService extends Thread implements Runnable, Discount {

    private static String CATALOG_NAME = "files/";

    public BankService(String name) {
        super(name);
    }

    @Override
    public void takeDiscount() {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int randomDiscount = r.nextInt(4);
        int choiceRandomDiscount = sc.nextInt();
        if (choiceRandomDiscount == 1) {
            System.out.println("Ваша скидка 3%");
        } else if (choiceRandomDiscount == 2) {
            System.out.println("Ваша скидка 5%");
        } else if (choiceRandomDiscount == 3) {
            System.out.println("Ваша скидка 7%");
        } else if (choiceRandomDiscount == 4) {
            System.out.println("Ваша скидка 10%");
        }

    }

    public void run() {

        takeDiscount();
        readAndWright();

    }

    public void readAndWright() {

        System.out.println("Выберите действие:");
        System.out.println("1. Сохранить информацию в базу");
        System.out.println("2. Получить информацию из базы");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 1) {
            dbWrite(sc);
        } else if (choice == 2) {
            dbRead(sc);
        }
    }

    private static void dbWrite(Scanner sc) {
        System.out.println("Укажите имя файла:");
        String fileName = sc.next();

        try (FileWriter fw = new FileWriter(CATALOG_NAME + fileName, true)) {
            System.out.println("Введите ФИО: " + sc.nextLine());
            fw.write("fio: " + sc.nextLine() + " "); //
            System.out.println("Введите clientID: ");
            fw.write("clientID: " + sc.nextInt() + " ");
            System.out.println("Введите номер паспорта: ");
            fw.write("passportNumber: " + sc.next() + " ");
            System.out.println("Введите номер карты: ");
            fw.write("cardNumber: " + sc.nextInt() + " ");
            fw.write("\n");

            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dbRead(Scanner sc) {

        System.out.println("Укажите имя файла:");

        String fileName = sc.next();

        System.out.println("Укажите id клиента:");

        String FindId = sc.next();

        try {
            processClientID(FindId);

            String clientID = "clientID: " + FindId + " ";
            try (BufferedReader br = new BufferedReader(new FileReader(CATALOG_NAME + fileName))) {

                List<String> listOfClient = new ArrayList<>();

                String s;
                while ((s = br.readLine()) != null) {

                    listOfClient.add(s);

                }
                boolean findSuccess = false;
                for (String id : listOfClient) {
                    if (id.indexOf(clientID) != -1) {
                        System.out.println(id);
                        findSuccess = true;
                    }
                }
                if (findSuccess != true) {
                    System.out.println("Клиент не найден");
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(fileName + " файл пуст или не найден." + " Введите повторно.");
                dbRead(sc);
            }

        } catch (ClientIdInvalidException e) {

            System.out.println(e.getMessage());
            System.out.println("Номер clientID: " + e.getClientID());
            e.printStackTrace();

        }


    }

    private static boolean processClientID(String clientID) throws ClientIdInvalidException {

        if (clientID.length() > 10) {
            throw new ClientIdInvalidException("Введенный id превышает 10 символов: " + clientID.length(), clientID);
        } else if (clientID.length() < 10) {
            throw new ClientIdInvalidException("Введенный id меньше 10 символов: " + clientID.length(), clientID);
        }
        return false;
    }

}
