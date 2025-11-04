public class MNThreadModel {
    public static void main(String[] args) {
        // Cria 100 virtual threads
        for (int i = 1; i <= 100; i++) {
            int threadId = i;
            Thread.startVirtualThread(() -> {
                System.out.println("Virtual Thread " + threadId + " executando.");
                try {
                    Thread.sleep(100); // simula trabalho
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Aguarda para garantir que todas as threads terminem
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
