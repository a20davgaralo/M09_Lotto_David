package principal.consumer;

public class SorteigMagatzem {

    private int[] sorteig;
    private boolean hi_ha_sorteig = false;

    public synchronized int[] agafaSorteig() {
        while (!hi_ha_sorteig) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sorteig agafat");
        hi_ha_sorteig = false;
        notifyAll();
        return sorteig;
    }

    public synchronized void guardaSorteig(int [] sorteig) {
        while (hi_ha_sorteig) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sorteig guardat");
        hi_ha_sorteig = true;
        this.sorteig = sorteig;
        notifyAll();
    }
}
