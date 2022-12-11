public class  Main {
    public static void main(String[] args) throws Exception {
        Credit credit = new Credit();

        while (true) {
            credit.printMenu();
            credit.selectItem();
        }
    }
}
