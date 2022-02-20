package principal.consumer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DinamicaSorteigProdCons {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ArrayList<int[]> sortejos = new ArrayList<>();

        ExecutorService es = Executors.newFixedThreadPool(2);

        SorteigMagatzem magatzem = new SorteigMagatzem();
        Thread productor = (new Thread(new SorteigProductor(magatzem)));
        Future<int[]> consumidor = es.submit(new SorteigConsumidor(magatzem, 4000));
        es.submit(productor);


            int[] sorteig = consumidor.get();

            SimpleDateFormat formatter = new SimpleDateFormat("E d MMM yyyy, HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            String diaIhora = formatter.format(date);
            System.out.println("Resultat del sorteig de: " + diaIhora);
            for (int i = 0; i < sorteig.length; i++) {
                System.out.print(sorteig[i] + " ");
            }
            System.out.println();
            if (sortejos.add(sorteig)) {
                System.out.println("Sorteig guardat correctament");
            }


    }


}

