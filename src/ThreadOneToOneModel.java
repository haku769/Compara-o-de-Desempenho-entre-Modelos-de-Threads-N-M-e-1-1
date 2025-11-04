public class ThreadOneToOneModel {
    public static void main(String[] args) {
        // Mede o tempo total de execução
        long inicio = System.currentTimeMillis();

        int numThreads = 100; // Cada thread de usuário será uma thread real
        Thread[] threads = new Thread[numThreads];

        System.out.println("Iniciando execução com " + numThreads + " threads reais...\n");

        // Cria e inicia todas as threads
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i + 1;
            threads[i] = new Thread(() -> {
                System.out.println("Thread " + threadId + " executando na " +
                        Thread.currentThread().getName());
                try {
                    Thread.sleep(250); // Simula trabalho (mesmo tempo dos outros modelos)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start(); // Inicia a thread
        }

        // Aguarda todas terminarem
        for (Thread t : threads) {
            try {
                t.join(); // Espera o término da thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Calcula e exibe o tempo total
        long fim = System.currentTimeMillis();
        System.out.println("\nTempo total de execução: " + (fim - inicio) + " ms");
    }
}
