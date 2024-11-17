import java.util.Random;
import java.util.Scanner;

public class GameDice {
    public static String printDice(int numRandom) {
        switch (numRandom) {
            case 1 -> {
                return """
                        +-------+
                        |       |
                        |   #   |
                        |       |
                        +-------+
                        """;
            }
            case 2 -> {
                return """
                        +-------+
                        |   #   |
                        |       |
                        |   #   |
                        +-------+
                        """;
            }
            case 3 -> {
                return """
                        +-------+
                        | #     |
                        |   #   |
                        |     # |
                        +-------+
                        """;
            }
            case 4 -> {
                return """
                        +-------+
                        | #   # |
                        |       |
                        | #   # |
                        +-------+
                        """;
            }
            case 5 -> {
                return """
                        +-------+
                        | #   # |
                        |   #   |
                        | #   # |
                        +-------+
                        """;
            }
            default -> {
                return """
                        +-------+
                        | #   # |
                        | #   # |
                        | #   # |
                        +-------+
                        """;
            }
        }
    }

    public static int rollTheDice() {
        return new Random().nextInt(6) + 1;
    }

    public static int gamePrint(int number) {
        int runNum;
        int increase = 0;
        for (int i = 0; i < 2; i++) {
            runNum = rollTheDice();
            increase += runNum;
            System.out.println(printDice(runNum));
        }
        System.out.println("On the dice fell " + increase + " points.");
        int mathAbs = increase - Math.abs(increase - number) * 2;
        System.out.println("Result is " + increase + " - " + "abs(" + increase + " - " + number + ")" + " * " + 2 + ": " + mathAbs + " points");
        return mathAbs;
    }
    public static void result() {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < 3) {
            int numUser = 0;
            int numComp;
            System.out.println("---          Start game          ---\n");
            System.out.print("Predict amount of points (2..12): ");
            int UserNumber = scanner.nextInt();
            System.out.println("User rolls the dices...");
            if (UserNumber > 1 && UserNumber <= 12) {
                numUser = gamePrint(UserNumber);
            } else {
                System.out.println("\n----=== write 2 to 12!!! ===---");
            }
            int comNum = new Random().nextInt(2, 13);
            System.out.println("\n\nComputer predicted " + comNum + " points");
            System.out.println("Computer rolls the dices...");
            numComp = gamePrint(comNum);
            int res = 0;
            String win;
            if (numComp == numUser) {
                win = "EQUALS";
            } else if (numComp > numUser) {
                win = "Computer  ";
                if (numUser > 0) res = numComp - numUser;
                else res = numComp;

            } else {
                win = "User  ";
                if (numComp > 0) res = numUser - numComp;
                else res = numUser;

            }
            System.out.println("-------------- Current score -----------------");
            System.out.println("numUser = " + numUser + " points");
            System.out.println("numComp = " + numComp + " points");
            if (!win.equalsIgnoreCase("EQUALS")) {
                System.out.println(win + "is ahead by " + res + " points!" +
                        "\n-----------------------------------------------");
            } else System.out.println(win + " EQUALS!" +
                    "\n-----------------------------------------------");

            i++;
            if (i == 3) {
                System.out.println("улантууну каалайсынбы (yes) же токтотуу (no): ");
                String next = new Scanner(System.in).next();
                if (next.equalsIgnoreCase("yes")) i = 0;
            }
        }
    }
}
