package command;

public class Loans {
    private final String nameBank;
    private final int sum;
    private final int interest;
    public  Loans(String nameBank, int sum, int interest){
        this.nameBank = nameBank;
        this.sum = sum;
        this.interest = interest;
    }
    public String getNameBank(){
        return nameBank;
    }

    public int getInterest(){
        return interest;
    }

    public int getSum(){
        return sum;
    }

    @Override
    public String toString() {
        return "Назва банку " + nameBank + " сума кредиту " + sum + " відсоток " + interest +"% річних";
    }

}

