package week_2_assigment;
import java.util.*;

public class main_2
 {
    static void checkPinLength(String pin) {
        if (pin.length() != 4)
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        else
            System.out.println("PIN length OK.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pin = sc.nextLine();

        checkPinLength(pin);
        sc.close();
    }
}