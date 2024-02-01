package step02_basic.chapter06_modifier.modifier3;

public class BankAccountMain {
    public static void main(String[] args){
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(10000);
        bankAccount.withdraw(3000);
        System.out.println("현재 잔고 확인: "+bankAccount.getBalance());
        bankAccount.withdraw(8000);
    }
}
