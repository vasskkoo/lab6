package menu;
import command.Command;
import java.io.FileReader;
import java.util.Scanner;


public class ListLoans extends Command {

    public void execute() throws Exception {
        System.out.println("Список ваших кредитів");
        list();
        System.out.println();
    }

    public void list() throws Exception {

        FileReader fileReader = new FileReader("credit.txt");
        Scanner sc = new Scanner(fileReader);
        int i = 0;
        while (sc.hasNextLine()) {
            i++;
            System.out.println(i + ". " + sc.nextLine());
        }
        fileReader.close();

    }
}
