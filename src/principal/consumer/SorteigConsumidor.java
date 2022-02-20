package principal.consumer;

import java.util.concurrent.Callable;

public class SorteigConsumidor implements Callable<int[]> {

    private SorteigMagatzem sorteigMagatzem;
    private int sleep;

    public SorteigConsumidor(SorteigMagatzem sorteigMagatzem, int sleep) {
        this.sorteigMagatzem = sorteigMagatzem;
        this.sleep = sleep;
    }

    @Override
    public int[] call() {
        while (true) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int[] sorteig = sorteigMagatzem.agafaSorteig();
            return sorteig;
        }
    }
}
