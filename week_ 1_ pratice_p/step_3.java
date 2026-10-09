
import java.util.*;

public class step_3 {
    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-8s %-12s %-12s %-10s %-15s%n",
                "Person", "Height", "Weight", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);

            System.out.printf("%-8d %-12.2f %-12.2f %-10.2f %-15s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] heights = new double[10];
        double[] weights = new double[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter height (m) and weight (kg) for person "
                    + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);
        sc.close();
    }
}