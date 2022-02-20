package principal.executorScheduled;

import java.util.concurrent.Callable;

public class SorteigCallable implements Callable<int[]> {

    public int[] call() {
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
}
