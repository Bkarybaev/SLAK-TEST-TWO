import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---          Start game          ---\n");
            System.out.print("Predict amount of points (2..12): ");
            int UserNumber = scanner.nextInt();
            System.out.println("User rolls the dices...");
            if (UserNumber > 1 && UserNumber <= 12) {
                gamePrint(UserNumber);
            } else {
                System.out.println("\n----=== write 2 to 12!!! ===---");
            }
            int computer = new Random().nextInt(2, 13);
            int comNum = computer;
            System.out.println("\n\nComputer predicted " + comNum + " points");
            System.out.println("Computer rolls the dices...");
            gamePrint(comNum);



        }
    }

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

    public static void gamePrint(int number) {
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
    }

}