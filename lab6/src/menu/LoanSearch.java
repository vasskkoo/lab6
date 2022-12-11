package menu;
import command.Command;
import command.Loans;

import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class LoanSearch extends Command {
    public void execute() throws Exception {
        Loans[] array = randomCredit(20);
        Loans[] arrays = listNameOfBank(array, 20);
        FileWriter fileWriter = new FileWriter("credit.txt", true);
        Scanner sc = new Scanner(System.in);
        int choose;
        choose  = sc.nextInt();
        int i = choose;
        if (choose < 6 && choose > 0){
            fileWriter.write(String.valueOf(arrays[i - 1]));  fileWriter.write('\n');
        }
        fileWriter.close();
    }

    public Loans[] randomCredit(int arrsize){
        Loans[] array = new Loans[arrsize];
        Random random = new Random();
        String[] name={"Приват банк", "Альфа-Банк", "Кредит банк"};
        int[] sum = {1000, 2000, 5000, 10000, 15000, 20000, 500000};
        for (int i = 0; i < arrsize; i++) {
            array[i] = new Loans(name[random.nextInt(name.length)], sum[random.nextInt(sum.length)], random.nextInt(10)+5);
        }
        return array;
    }

    public Loans[] listNameOfBank (Loans[] array, int arraySize) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Веддіть назву банку ");
        String name = scanner.nextLine();
        System.out.println("Введіть суму ");
        int sum = scanner.nextInt();
        System.out.println("Введіть відсоток річних");
        System.out.print("з ");
        int minInterest = scanner.nextInt();
        System.out.print("до ");
        int maxInterest = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < arraySize; i++) {
            if (array[i].getNameBank().equals(name) && array[i].getSum() == sum && array[i].getInterest() < maxInterest && array[i].getInterest() > minInterest) {
                count++;
            }
        }
        int j = 0;
        int counter = 0;
        Loans[] ar = new Loans[count];
        for (int i = 0; i < arraySize; i++) {
            if (array[i].getNameBank().equals(name)&& array[i].getSum() == sum && array[i].getInterest()< maxInterest && array[i].getInterest()> minInterest) {
                counter++;
                System.out.println(counter + ". " + array[i].toString());
                ar[j++] = new Loans(array[i].getNameBank(), array[i].getSum(), array[i].getInterest());
            }
        }
        return ar;
    }
}
