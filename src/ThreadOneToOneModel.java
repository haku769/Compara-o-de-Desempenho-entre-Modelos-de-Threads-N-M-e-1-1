public class ThreadOneToOneModel {
    public static void main(String[] args) {
        // Criando 3 threads independentes
        for (int i = 1; i <= 3; i++) {
            final int threadId = i;
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println("Thread " + threadId + " executando passo " + j);
                    try {
                        Thread.sleep(500); // Simula trabalho
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
