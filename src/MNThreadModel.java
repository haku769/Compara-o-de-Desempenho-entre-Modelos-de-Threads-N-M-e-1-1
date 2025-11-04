import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MNThreadModel {
    public static void main(String[] args) {
        // Mede o tempo total de execução
        long inicio = System.currentTimeMillis();

        int numThreadsSistema = 10;  // M = número de threads reais (do sistema)
        int numTarefasUsuario = 100; // N = número de tarefas de "usuário"

        // Cria um pool fixo de threads do sistema operacional (modelo N:M)
        ExecutorService pool = Executors.newFixedThreadPool(numThreadsSistema);

        System.out.println("Iniciando execução com " + numTarefasUsuario +
                " tarefas em " + numThreadsSistema + " threads do sistema...\n");

        // Envia as tarefas (N) para o pool (M)
        for (int i = 1; i <= numTarefasUsuario; i++) {
            final int tarefaId = i;
            pool.submit(() -> {
                System.out.println("Tarefa " + tarefaId + " executando na thread " +
                        Thread.currentThread().getName());
                try {
                    Thread.sleep(250); // Simula trabalho (mesmo tempo que o código original)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Finaliza o pool e aguarda o término de todas as tarefas
        pool.shutdown();
        try {
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Algumas tarefas não terminaram a tempo.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calcula e exibe o tempo total
        long fim = System.currentTimeMillis();
        System.out.println("\nTempo total de execução: " + (fim - inicio) + " ms");
    }
}
