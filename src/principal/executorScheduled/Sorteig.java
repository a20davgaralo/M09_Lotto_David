package principal.executorScheduled;

public class Sorteig  implements Runnable{

    public static int[] generateRandom() {
        int[] numArray = new int[7];
        int e = (int) ((Math.random() * (49 - 1)) + 1);
        numArray[0] = e;
        for (int i = 1; i < numArray.length; i++) {
            e = (int) ((Math.random() * (49 - 1)) + 1);
            for (int j = 0; j < i; j++) {
                if (numArray[j] == e) {
                    i--;
                } else {
                    numArray[i] = e;
                }
            }
        }
        return numArray;
    }

    public static void printLotto() {
        int result[] = generateRandom();
        //System.out.println("Result of the lottery: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        //System.out.println("\n");
    }

    public void run() {
        printLotto();
    }
}
