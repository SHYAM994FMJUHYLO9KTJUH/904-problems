package week_9_assignment;
import java.util.*;

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    abstract boolean usesBus();

    double getTotalFee() {
        return getTuition() + (usesBus() ? 12000 : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000 + 60000;
    }

    boolean usesBus() {
        return false;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double getTuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class main_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s;

            switch (type) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                default:
                    s = new Scholar(name);
            }

            double fee = s.getTotalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}