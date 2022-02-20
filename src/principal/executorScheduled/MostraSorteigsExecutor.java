package principal.executorScheduled;

import java.util.ArrayList;
import java.util.concurrent.*;

public class MostraSorteigsExecutor {

    private static final int TEMPS_SORTEIG = 3;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ArrayList<int[]> sortejos = new ArrayList<>();

        ScheduledExecutorService serveiPrograma = Executors.newSingleThreadScheduledExecutor();

        /*while (true) {
            ScheduledFuture<int[]> future = serveiPrograma.schedule(new SorteigCallable(), TEMPS_SORTEIG, TimeUnit.SECONDS);

            int[] sorteig = future.get();
            System.out.println("Sorteig capturat");
            for (int i = 0; i < sorteig.length; i++) {
                System.out.print(sorteig[i] + " ");
            }
            System.out.println();
        }*/

        for (int i = 0; i < 5; i++) {
            ScheduledFuture<int[]> future = serveiPrograma.schedule(new SorteigCallable(), TEMPS_SORTEIG, TimeUnit.SECONDS);

            int[] sorteig = future.get();
            sortejos.add(sorteig);

        }

        for (int[] sorteigUnic: sortejos) {
            System.out.println("Sorteig capturat número " + sortejos.indexOf(sorteigUnic));
            for (int i = 0; i < sorteigUnic.length; i++) {
                System.out.print(sorteigUnic[i] + " ");
            }
            System.out.println();
        }

        serveiPrograma.shutdown();
      /*ScheduledFuture<?> future = serveiPrograma.scheduleAtFixedRate(new Sorteig(), 0, TEMPS_SORTEIG, TimeUnit.SECONDS);

      int[] sorteig = (int[]) future.get();
      System.out.println("Sorteig capturat");
      for (int i = 0; i < sorteig.length; i++) {
          System.out.println(sorteig + " ");
      }*/
    }
}
