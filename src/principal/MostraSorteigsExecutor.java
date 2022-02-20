package principal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MostraSorteigsExecutor {

    private static final int TEMPS_SORTEIG = 30;

    public static void main(String[] args) {

        ScheduledExecutorService serveiPrograma = Executors.newSingleThreadScheduledExecutor();

        serveiPrograma.scheduleAtFixedRate(new Sorteig(), 0, TEMPS_SORTEIG, TimeUnit.SECONDS);

    }
}
