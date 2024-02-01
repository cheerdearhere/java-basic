package step02_basic.chapter06_modifier.modifier3;

public class BankAccount {
    private int balance;

    public BankAccount(){
        this.balance = 0;
    }

//    public methods
    /**
     * 입금
     * @param amount 입금 금액
     */
    public void deposit(int amount){
        if(!isAmountValid(amount)){
            System.out.println("유효하지 않은 금액입니다.\n    - 입력한 금액: "+amount);
        }else {
            balance += amount;
            System.out.println(amount+ "원을 입금했습니다.\n    - 입금 후 금액: "+amount);
         }
    }

    /**
     * 출금 로직
     * @param amount 출금할 금액
     */
    public void withdraw (int amount){
        if(!isAmountValid(amount)){
            System.out.println("유효하지 않은 금액입니다.\n    - 입력한 금액: "+amount);
        }else if(balance<amount) {
            System.out.println("잔액이 부족합니다.\n    - 현재 잔고: "+balance);
        }else {
            balance -= amount;
            System.out.println(amount+ "원을 출금했습니다.\n    - 입금 후 금액: "+amount);
        }
    }

    /**
     * 현재 통장 잔고를 반환
     * @return 현재 통장 잔고 금액
     */
    public int getBalance(){
        return balance;
    }

//    private methods
    /**
     * 입력된 값이 0 이상인지 확인
     * @param amount 입력한 금액
     * @return 0보다 크면 true
     */
    private boolean isAmountValid(int amount){
        return amount > 0;
    }
}
