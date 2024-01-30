package step02_basic.chapter03_oop.ex.oop2Question;

public class Account {
    private int balance;

    protected void deposit(int amount){
        balance += amount;
        showBalance();
    }
    protected void withdraw(int amount){
        if(balance<amount){
            System.out.print("잔액 부족 - ");
        }else {
            balance-=amount;
        }
        showBalance();
    }
    protected void showBalance(){
        System.out.println("현재 잔고: "+balance);
    }
}
