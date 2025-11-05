import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MNThreadModel {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        int numThreadsSistema = 10;
        int numTarefasUsuario = 100;

        ExecutorService pool = Executors.newFixedThreadPool(numThreadsSistema);

        System.out.println("Iniciando execução com " + numTarefasUsuario +
                " tarefas em " + numThreadsSistema + " threads do sistema...\n");

        for (int i = 1; i <= numTarefasUsuario; i++) {
            final int tarefaId = i;
            pool.submit(() -> {
                System.out.println("Tarefa " + tarefaId + " executando na thread " +
                        Thread.currentThread().getName());
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();
        try {
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Algumas tarefas não terminaram a tempo.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long fim = System.currentTimeMillis();
        System.out.println("\nTempo total de execução: " + (fim - inicio) + " ms");
    }
}
