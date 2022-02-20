package principal.processos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SorteigProcess {

    public static void main(String[] args) throws IOException {

        ProcessBuilder process = new ProcessBuilder("java", "-jar", "M09_Lotto_David.jar");
        Process sortida = process.start();

        print(sortida.getInputStream());


    }

    //Redireccionem la sortida de l'InputStream a un buffer de lectura i l'anem mostrant per pantalla tal com va sortint
    private static void print(InputStream input) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    }
}

