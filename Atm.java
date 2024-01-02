import java.util.Scanner;

public class Atm{
    private BankAccount userAccount;

    public Atm(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayOptions() {
        System.out.println("Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline not consumed by nextInt()
        switch (option) {
            case 1:
                withdraw(scanner);
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                checkBalance();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                start();
        }
    }

    public void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        float amount = scanner.nextFloat();
        if (userAccount.getBalance() >= amount) {
            userAccount.setBalance(userAccount.getBalance() - amount);
            System.out.printf("Withdrew %f. New balance: %f", amount, userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Please try again.");
        }
    }

    public void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        float amount = scanner.nextFloat();
        userAccount.setBalance(userAccount.getBalance() + amount);
        System.out.printf("Deposited %f. New balance: %f", amount, userAccount.getBalance());
    }

    public void checkBalance() {
        System.out.printf("Your current balance is: %f", userAccount.getBalance());
    }
}
