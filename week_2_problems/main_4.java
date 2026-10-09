package week_2_problems;
import java.util.*;

public class main_4
 {
    static String maskPhoneNumber(String phone) {
        if (phone.length() != 10)
            return "Invalid phone number";

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i)))
                return "Invalid phone number";
        }

        StringBuilder sb = new StringBuilder("XXXXXX");
        sb.insert(6, "-" + phone.substring(6));

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();
        System.out.println(maskPhoneNumber(phone));
        sc.close();
    }
}