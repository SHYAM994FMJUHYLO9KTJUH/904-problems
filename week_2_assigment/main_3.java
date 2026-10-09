package week_2_assigment;
import java.util.*;

public class main_3
 {
    static void parseInventoryRecord(String csvLine) {
        String[] data = csvLine.split(",", -1);

        if (data.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + data[0].trim()
                + " | SKU: " + data[1].trim()
                + " | Qty: " + data[2].trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String csvLine = sc.nextLine();

        parseInventoryRecord(csvLine);
        sc.close();
    }
}