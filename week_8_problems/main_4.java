package week_8_problems;
import java.util.*;
import java.util.regex.*;

abstract class Question {
    String correct, answer;
    double points;

    Question(String correct, String answer, double points) {
        this.correct = correct;
        this.answer = answer;
        this.points = points;
    }

    abstract double grade();
    abstract String getType();
}

class MCQ extends Question {
    MCQ(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TF extends Question {
    TF(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        return answer.equals(correct) ? points : 0;
    }

    String getType() {
        return "TF";
    }
}

class Essay extends Question {
    Essay(String c, String a, double p) {
        super(c, a, p);
    }

    double grade() {
        String text = answer.toLowerCase();
        String[] keywords = correct.split(",");
        int count = 0;

        for (String keyword : keywords) {
            if (text.contains(keyword.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class main_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String type = line.substring(0, line.indexOf(' ')).trim();

            Matcher matcher = pattern.matcher(line);
            List<String> values = new ArrayList<>();

            while (matcher.find()) {
                values.add(matcher.group(1));
            }

            double points = Double.parseDouble(
                    line.substring(line.lastIndexOf('"') + 1).trim());

            String correct = values.get(1);
            String answer = values.get(2);

            Question q;

            switch (type) {
                case "MCQ":
                    q = new MCQ(correct, answer, points);
                    break;
                case "TF":
                    q = new TF(correct, answer, points);
                    break;
                default:
                    q = new Essay(correct, answer, points);
            }

            double score = q.grade();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}