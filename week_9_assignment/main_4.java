package week_9_assignment;
import java.util.*;

abstract class Cab {
    static final double MIN_FARE = 100.0;
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double getFare() {
        return Math.max(km * getRate(), MIN_FARE);
    }
}

interface NightService {
    double getNightFare();
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double getNightFare() {
        return getFare() * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double getNightFare() {
        return getFare() * 1.20;
    }
}

public class main_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab c;

            switch (type) {
                case "MINI":
                    c = new Mini(km);
                    break;
                case "SEDAN":
                    c = new Sedan(km);
                    break;
                default:
                    c = new SUV(km);
            }

            if (time.equals("NIGHT") && !(c instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = time.equals("NIGHT")
                    ? ((NightService) c).getNightFare()
                    : c.getFare();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
