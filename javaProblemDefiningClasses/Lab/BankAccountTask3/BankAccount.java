package Lab.BankAccountTask3;

public class BankAccount {
  //  private  final static double DEFAULT_INTEREST_RATE = 0.02;
  // private  double interestRate = DEFAULT_INTEREST_RATE;
  // private static int bankAccountCount = 1;
    private int id;
    private  double balance;
    private static  double interestRate = 0.02;
    private static int accountsCount = 0;

    /*
    //правя празен конструктор, никой не ни гарантира, че констриктора ще се извика
    public BankAccount(){
        interestRate = 0.02;
    }
     */
    public BankAccount(){
        accountsCount++;
        this.id = accountsCount;
        this.balance = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }



    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void deposit(double money){
        this.balance += money;
    }
    public double getInterest(int years){
        return years * interestRate * this.balance;
    }
}
