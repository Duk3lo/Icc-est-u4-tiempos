import java.util.concurrent.Callable;

import models.Results;

public class Benchmark {
    public static Results medir_tiempo(Callable<Void> func, int size) {
        try {
            long inicio = System.nanoTime();
            func.call();
            long fin = System.nanoTime();
            long tiempoNano = fin - inicio;
            double tiempoSeg = tiempoNano / 1_000_000_000.0;
            Results result = new Results(1, "Imprimir "+ size +" numeros", tiempoSeg);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error medido en el tiempo", e);
        }
    }

    public static Results medir_tiempo(Runnable func, int size) {
        try {
            long inicio = System.nanoTime();
            func.run();
            long fin = System.nanoTime();
            long tiempoNano = fin - inicio;
            double tiempoSeg = tiempoNano / 1_000_000_000.0;
            Results result = new Results(1, "Imprimir "+ size +" numeros", tiempoSeg);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error medido en el tiempo", e);
        }
    }
}
