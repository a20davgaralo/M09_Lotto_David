package principal.consumer;

public class SorteigProductor implements Runnable{

    private SorteigMagatzem sorteigMagatzem;

    public SorteigProductor(SorteigMagatzem sorteigMagatzem) {
        this.sorteigMagatzem = sorteigMagatzem;
    }

    public void run() {

        while (true) {
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
            sorteigMagatzem.guardaSorteig(numArray);
        }
    }
}
