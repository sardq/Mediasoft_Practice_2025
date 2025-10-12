package task1;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Сергей");
        System.out.println(account.toString());
        account.deposit(100);
        account.withdraw(50);
        account.withdraw(60);
        System.out.println(account.toString());
        BankAccount otherAccount = new BankAccount("Иван");
        account.transfer(otherAccount, 30);
        System.out.println(account);
        System.out.println(otherAccount);
        System.out.println("Эквивалентны ли  объекты? Ответ: " +account.equals(otherAccount));
        }

}