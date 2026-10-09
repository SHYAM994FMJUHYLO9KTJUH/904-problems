package week_8_problems;
import java.util.*;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
    abstract String getType();
}

class Card extends Payment {
    Card(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 1.02;
    }

    String getType() {
        return "CARD";
    }
}

class Wallet extends Payment {
    Wallet(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 1.01;
    }

    String getType() {
        return "WALLET";
    }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount;
    }

    String getType() {
        return "BANKTRANSFER";
    }
}

public class main_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            Payment p;

            switch (type) {
                case "CARD":
                    p = new Card(amount);
                    break;
                case "WALLET":
                    p = new Wallet(amount);
                    break;
                default:
                    p = new BankTransfer(amount);
            }

            double result = p.calculateAmount();
            System.out.printf("%s: %.2f%n", p.getType(), result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
