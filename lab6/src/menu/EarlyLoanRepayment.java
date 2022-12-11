package menu;
import command.Command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;



public class EarlyLoanRepayment extends Command {

    public void execute() throws Exception {
        System.out.println("Дострокове погашення кредиту");
        removeCredit();
    }

    public void removeCredit() throws  Exception {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader("credit.txt");
        int choose;
        BufferedReader reader = null;
        PrintWriter writer = null;
        Scanner sc = new Scanner(fileReader);
        int  i = 0;
        while (sc.hasNextLine()){
            i++;
            System.out.println(i+". "+ sc.nextLine());
        }
        choose = scanner.nextInt();
        try {
            File file = new File("credit.txt");
            String fileToWrite = "new.txt";
            reader = new BufferedReader(new FileReader(file));
            writer = new PrintWriter(new FileWriter(fileToWrite));
            int current = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (current != (choose-1)) {
                    writer.println(line);
                }
                current++;
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (writer != null) {
                writer.close();
            }
            if (reader != null) {
                reader.close();
            }
        }

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("new.txt");
            fw = new FileWriter("credit.txt");
            int c = fr.read();
            while(c != -1) {
                fw.write(c);
                c = fr.read();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            close(fr);
            close(fw);
        }
    }
    public static void close(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch(IOException e) {
            //
        }
    }

}
