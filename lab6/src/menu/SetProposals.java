package menu;

import command.Command;
import command.Loans;

import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class SetProposals extends Command {
    Scanner sc = new Scanner(System.in);
    public void execute() throws Exception {
        Loans[] array = randomCredit(5);
        printCredit(array);
        FileWriter fileWriter = new FileWriter("credit.txt", true);
        int choose;
        choose  = sc.nextInt();
        int i = choose;
        if (choose < 6 && choose > 0){
            fileWriter.write(String.valueOf(array[i - 1]));  fileWriter.write('\n');
        }
        fileWriter.close();
    }

    public Loans[] randomCredit(int arrsize){
        Loans[] array = new Loans[arrsize];
        Random random = new Random();
        String[] name={"Приват банк", "Монобанк", "Альфа банк", "УкрСибБанк"};
        int[] sum = {1000, 5000, 10000, 15000, 20000, 500000};
        for (int i = 0; i < arrsize; i++) {
            array[i] = new Loans(name[random.nextInt(name.length)], sum[random.nextInt(sum.length)], random.nextInt(10)+5);
        }
        return array;
    }
    public static void printCredit(Loans [] array){
        int i = 0;
        for (Loans loans : array) {
            i++;
            System.out.println(i + ". " + loans.toString());
        }
    }
}