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
            fw.write("passportNumber: " + sc.nextInt() + " ");
            System.out.println("Введите номер карты: ");
            fw.write("cardNumber: " + sc.nextInt() + " ");
            fw.write("\n");

            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dbRead(Scanner sc) {
        System.out.println("Укажите имя файла: ");
        String fileName = sc.next();
        System.out.println("Укажите имя клиента для поиска в файле: ");
        String findName = sc.next();

        try (DataInputStream dis = new DataInputStream(new FileInputStream(CATALOG_NAME + fileName))) {
            Client client = new Client(dis.readUTF(), dis.readInt(), dis.readUTF(), dis.readInt());

            if(client.getFio().equals(findName)){
            System.out.println(client);
            }
            else
                System.out.println(findName + " не найден");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при поиске ");
           // dbWrite(sc);
        }
    }

    /*private static void dbRead(Scanner sc) {
        System.out.println("Укажите имя файла:");
        String fileName = sc.next();
        try (BufferedReader br = new BufferedReader(new FileReader(CATALOG_NAME + fileName))) {

            List<Client> listOfClient = new ArrayList<>();

            String currentLine = "";
            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
                if (currentLine != null && !currentLine.isBlank())
                    listOfClient.add(convertStringToClient(currentLine));
            }

            System.out.println(listOfClient);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(fileName + "в базе не найден(а)," + " введи имя повторно.");
            dbRead(sc);
        }
    }

    private static Client convertStringToClient(String currentLine) {

        String[] split = currentLine.split(" ");

        Client client2 = new Client();

        for (String s : split) {
            getNameAndSet(s, client2);
            getClientIDAndSet(s, client2);
        }
        return client2;
    }

    private static void getClientIDAndSet(String s, Client p) {   // age:22
        if (s != null && s.contains("age:")) {
            p.setClientId(Integer.valueOf(s.split(":")[1]));
        }
    }

    private static void getNameAndSet(String s, Client p) { // name:Света
        if (s != null && s.contains("name:")) {
            p.setFio(s.split(":")[1]);
        }
    }*/
}
