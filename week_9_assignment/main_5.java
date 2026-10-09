package week_9_assignment;
import java.util.*;

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double getUnits() {
        return getPower() * hours / 1000;
    }

    double getCost() {
        return getUnits() * 8;
    }
}

interface SaverMode {
    double getSaverUnits();
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double getPower() {
        return 1500;
    }

    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double getPower() {
        return 500;
    }

    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}

public class main_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();
            boolean saver = sc.hasNext() && sc.next().equals("SAVER");

            Appliance a;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge(hours);
                    break;
                case "AC":
                    a = new AC(hours);
                    break;
                case "TV":
                    a = new TV(hours);
                    break;
                default:
                    a = new Washer(hours);
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = saver
                    ? ((SaverMode) a).getSaverUnits()
                    : a.getUnits();

            double cost = units * 8;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            total += cost;
        }

        System.out.printf("Total Cost: %.2f%n", total);
        sc.close();
    }
}