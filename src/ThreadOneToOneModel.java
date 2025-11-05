public class ThreadOneToOneModel {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();

        int numThreads = 100;
        Thread[] threads = new Thread[numThreads];

        System.out.println("Iniciando execução com " + numThreads + " threads reais...\n");

        for (int i = 0; i < numThreads; i++) {
            final int threadId = i + 1;
            threads[i] = new Thread(() -> {
                System.out.println("Thread " + threadId + " executando na " +
                        Thread.currentThread().getName());
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long fim = System.currentTimeMillis();
        System.out.println("\nTempo total de execução: " + (fim - inicio) + " ms");
    }
}
