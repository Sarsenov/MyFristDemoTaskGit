
import java.util.Scanner;

public class taskHH {

    public static String[][] graphic;


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int num_doctor = scan.nextInt();

        graphic = new String[num_doctor][8];


        for (int i = 0; i < num_doctor; i++) {

            System.out.println((i + 1) + "th doctor");
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    System.out.println("Name of doctor: ");
                } else {
                    System.out.println(j + "th day");
                }
                graphic[i][j] = scan.next();
            }
        }


        determineSameDoc(graphic, num_doctor);

        for (int i = 0; i < num_doctor; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(graphic[i][j] + "\t");
            }
            System.out.println();
        }


    }


    public static void determineSameDoc(String[][] graphic, int numDoc) {
        for (int i = 0; i < numDoc; i++) {
            for (int j = i + 1; j < numDoc; j++) {

                if (graphic[i][0].equals(graphic[j][0])) {
                    joinGraphic(i, j);
                }
            }
        }
    }

    private static void joinGraphic(int first, int second) {

        for (int i = 1; i < 8; i++) {
            int len = graphic[first][i].length();
            int len2 = graphic[second][i].length();
            if (len == 11 && len2 == 11) {
                int f1 = Integer.valueOf(graphic[first][i].substring(0, 2));
                int f2 = Integer.valueOf(graphic[first][i].substring(6, 8));

                int s1 = Integer.valueOf(graphic[second][i].substring(0, 2));
                int s2 = Integer.valueOf(graphic[second][i].substring(6, 8));


                if (f2 >= s1) {
                    graphic[first][i] = f1 + ":00-" + s2 + ":00";
                }
                if (s2 >= f1) {
                    graphic[first][i] = s1 + ":00-" + f2 + ":00";
                }
                if (s1 >= f1 && f2 >= s2) {
                    graphic[first][i] = f1 + ":00-" + f2 + ":00";
                }
                if (f1 >= s1 && s2 >= f2) {
                    graphic[first][i] = s1 + ":00-" + s2 + ":00";
                }
                if (s1 > f2) {
                    graphic[first][i] = f1 + ":00-" + f2 + ":00," + s1 + ":00-" + s2 + ":00";
                }
                if (f1 > s2) {
                    graphic[first][i] = s1 + ":00-" + s2 + ":00," + f1 + ":00-" + f2 + ":00";
                }

            } else {
                graphic[first][i] = graphic[first][i] + graphic[second][i];
            }


        }

        for (int i = 0; i < 8; i++) {
            graphic[second][i] = "";
        }
    }
}