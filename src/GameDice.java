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

        int arrayLen = 3;
        int[] predictedUser = new int[arrayLen];
        int[] diceUser = new int[arrayLen];
        int[] resultUser = new int[arrayLen];
        int[] predictedComp = new int[arrayLen];
        int[] diceComp = new int[arrayLen];
        int[] resultComp = new int[arrayLen];
        while (i < 3) {

            int numUser = 0;
            int numComp;
            System.out.println("---          Start game          ---\n");
            System.out.print("Predict amount of points (2..12): ");
            int UserNumber = scanner.nextInt();
            predictedUser[i] = UserNumber;

            System.out.println("User rolls the dices...");
            if (UserNumber > 1 && UserNumber <= 12) {
                numUser = gamePrint(UserNumber);
                diceUser[i] = numUser;
            } else {
                System.out.println("\n----=== write 2 to 12!!! ===---");
            }
            int comNum = new Random().nextInt(2, 13);
            predictedComp[i] = comNum;
            System.out.println("\n\nComputer predicted " + comNum + " points");
            System.out.println("Computer rolls the dices...");
            numComp = gamePrint(comNum);
            diceComp[i] = numComp;

            int res = 0;
            String win;
            if (numComp == numUser) {
                win = "EQUALS";
                resultUser[i] = res;
                resultComp[i] = res;
            } else if (numComp > numUser) {
                win = "Computer  ";
                if (numComp < 0) {
                    res = Math.abs(numComp);
                    res -= Math.abs(numUser);
                    resultComp[i] = res;
                } else {
                    res = numComp - numUser;
                    resultComp[i] = res;
                }
            } else {
                win = "User  ";
                if (numUser < 0) {
                    res = Math.abs(numUser);
                    res -= Math.abs(numComp);
                    resultUser[i] = res;
                } else {
                    res = numUser - numComp;
                    resultUser[i] = res;
                }
            }
            System.out.println("-------------- Current score -----------------");
            System.out.println("numUser = " + numUser + " points");
            System.out.println("numComp = " + numComp + " points");
            if (!win.equalsIgnoreCase("EQUALS")) {
                System.out.println(win + "is ahead by " + res + " points!" +
                        "\n-----------------------------------------------");
            } else System.out.println(win + " -> user : " + numUser + " computer : " + numComp +
                    "\n-----------------------------------------------");

            i++;
            arrayLen++;

            int resUser = 0;
            for (int i1 : resultUser) {
                resUser += i1;
            }
            int resComp = 0;
            for (int i1 : resultComp) {
                resComp += i1;
            }
            String results;
            if (resComp == resUser) {
                results = "User or Computer Equal ";
            } else {
                int result = Math.max(resUser, resComp);
                results = resUser > resComp ? " User " : "Computer ";
                results += String.valueOf(result);
                results += " points more";
            }


            System.out.printf("""
                        --------------------Finish Game-----------------------
                        
                        Round |              User |                  Computer
                        ------+-------------------+---------------------------
                              | Predicted:   %d   | Predicted:   %d
                        - 1 - | Dice     :   %d   | Dice     :   %d
                              | Result   :   %d   | Result   :   %d
                        ------+-------------------+-----------------------------
                              | Predicted:   %d   | Predicted:   %d
                        - 2 - | Dice     :   %d   | Dice     :   %d
                              | Result   :   %d   | Result   :   %d
                        ------+-------------------+-----------------------------
                              | Predicted:   %d   | Predicted:   %d
                        - 3 - | Dice     :   %d   | Dice     :   %d
                              | Result   :   %d   | Result   :   %d
                        ------+-------------------+-----------------------------
                        Total | Points:      %d   | Points:      %d
                        
                        %s . Congratulations!
                        """, predictedUser[0], predictedComp[0], diceUser[0], diceComp[0], resultUser[0], resultComp[0],
                    predictedUser[1], predictedComp[1], diceUser[1], diceComp[1], resultUser[1], resultComp[1],
                    predictedUser[2], predictedComp[2], diceUser[2], diceComp[2], resultUser[2], resultComp[2],resUser,resComp,results);


            if (i == 3) {
                System.out.println("улантууну каалайсынбы (yes) же токтотуу (no): ");
                String next = new Scanner(System.in).next();
                if (next.equalsIgnoreCase("yes")){
                    i = 0;
                }
            }
        }

    }
}
