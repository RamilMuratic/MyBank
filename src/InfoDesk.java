import java.util.List;
import java.util.Random;

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
        String data = "11/05/22";
        kassa.giveMeCashReceiptOnDate(data);
        System.out.println("Chek on date " + data + ":");
        process(kassa.getChekOnData());
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

    }
    public String getTicket() {
        return ticket;
    }

    public String getUslugaType() {
        return uslugaType;
    }

    private static void process(List<CashReceipt> chekOnData) {
        while (chekOnData.size() > 0) {
            CashReceipt cR = chekOnData.get(0);
            System.out.println(cR);
            chekOnData.remove(cR);
        }
    }
}







