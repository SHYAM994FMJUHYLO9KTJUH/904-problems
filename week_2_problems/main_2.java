public class main_2
 {
    static void parseStudentRecord(String csvLine) {
        String[] data = csvLine.split(",", -1);

        if (data.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + data[0].trim()
                + " | Roll No: " + data[1].trim()
                + " | Dept: " + data[2].trim());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String csvLine = sc.nextLine();
        parseStudentRecord(csvLine);
        sc.close();
    }
}