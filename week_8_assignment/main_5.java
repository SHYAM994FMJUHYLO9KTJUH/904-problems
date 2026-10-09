package week_8_assignment;
import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, String date) {
        this.name = name;
        this.startDate = LocalDate.parse(date);
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class Basic extends Subscription {
    Basic(String name, String date) {
        super(name, date);
    }

    int getValidityDays() {
        return 30;
    }
}

class Standard extends Subscription {
    Standard(String name, String date) {
        super(name, date);
    }

    int getValidityDays() {
        return 90;
    }
}

class Premium extends Subscription {
    Premium(String name, String date) {
        super(name, date);
    }

    int getValidityDays() {
        return 365;
    }
}

public class main_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            Subscription s;

            switch (type) {
                case "BASIC":
                    s = new Basic(name, date);
                    break;
                case "STANDARD":
                    s = new Standard(name, date);
                    break;
                default:
                    s = new Premium(name, date);
            }

            System.out.println(s.name + ": " + s.getRenewalDate());
        }

        sc.close();
    }
}