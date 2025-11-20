public class App {
    public static void main(String[] args) {
        long inicio_millins = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            String s = "Numero: "+ i;
            System.out.println(s);
        }

        long fin = System.nanoTime();
        
        long tiempoNano = fin - inicio_millins;
        double tiempoSeg = tiempoNano / 1_000_000_000.0;
        System.out.println("Tiempo transcurrido: "+ tiempoNano + " nanos");
        System.out.println("Tiempo transcurrido: " + tiempoSeg + " segundos");
    }
}
