package ru.myBank.service;

import ru.myBank.model.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankService {

    private String[] arrayServices = {"Ритейл", "Фондовые услуги", "Пенсионные услуги", "Ипотечные услуги", "Кредитование"};

    public String[] getArrayServices() {
        return arrayServices;
    }

    private static String CATALOG_NAME = "files/";

    private Client Client1 = new Client("92154785", 1, "Вася", 1212);
    private Client Client2 = new Client("45635463", 2, "Федя", 2222);
    private Client Client3 = new Client("69868688", 13, "Коля", 3232);
    private Client Client4 = new Client("85388883", 11, "Маша", 4242);
    private Client Client5 = new Client("22282828", 6, "Миша", 5252);


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

        String clientID = "clientID: "+sc.next()+" ";
        try (BufferedReader br = new BufferedReader(new FileReader(CATALOG_NAME + fileName))) {

            List<String> listOfClient = new ArrayList<>();

            String s;
            while ((s = br.readLine()) != null) {

               listOfClient.add(s);

            }
            boolean findsuccess = false;
           for (String id : listOfClient) {
                if (id.indexOf(clientID)!=-1) {
                    System.out.println(id);
                    findsuccess = true;
                }
            }
           if (findsuccess!=true){
               System.out.println("Клиент не найден");
           }



        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(fileName + "файл пуст или не найден." + " Введите повторно.");
            dbRead(sc);
        }
    }

/*
    private static Client addClient() {
        Client client2 = new Client();

        int[] idSearch;

        for (int z : idSearch) {

            getClientIDAndSet(z, client2);
        }
        return client2;
    }

    private static void getClientIDAndSet(String s, Client p) {
        client2.setClientId(Integer.valueOf(z[1]));
    }
*/




}
