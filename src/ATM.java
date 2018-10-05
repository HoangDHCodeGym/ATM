import java.util.Scanner;

public class ATM {
    private Account[] accountList;

    public ATM(int numberOfAccount) {
        accountList = new Account[numberOfAccount];
        for (int i = 0; i < numberOfAccount; i++) {
            accountList[i] = new Account(i, 100);
        }
    }

    public int findId(int id) {
        for (int i = 0; i < accountList.length; i++) {
            if (accountList[i].getId() == i) {
                return i;
            }
        }
        return -1;
    }

    public void accountManager(int index) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            System.out.printf("Main Menu \n 1: check balance \n 2: withdraw \n 3: deposit \n 4: exit \nEnter choice: ");
            choice = scanner.nextInt();
            Account account = accountList[index];
            double amount;
            switch (choice) {
                case 1:
                    System.out.println("The balance is " + account.getBalance());
                    break;
                case 2:
                    System.out.printf("Please enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                    System.out.println("Withdraw successfully! The balance is " + account.getBalance());
                    break;
                case 3:
                    System.out.printf("Please enter the amount to deposit: ");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    System.out.println("Deposit successfully! The balance is " + account.getBalance());
                    break;
                case 4:
                    break;
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int id;
        while (true) {
            System.out.printf("Please enter account ID: ");
            id = scanner.nextInt();
            if (this.findId(id) != -1) {
                this.accountManager(id);
            } else {
                System.out.println("Id not found on system, please try again");
            }
        }
    }
}
