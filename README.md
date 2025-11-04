Alunos João Guilherme Marques, João Pedro Cardoso de Liz, Gabriel Baczinski Santana
Modelo N:M
Cenário	              
Teste 1: Número de Threads: 10                     
Numero de tarefas: 100
Tempo de execução:2524 + 2519 + 2522     
Media: 2.521 ms 
------------------------------------
Teste 2 :
Número de Threads:  100
Numero de tarefas: 100
Tempo de execução:   270 + 271 + 271   
Media: 270,6 ms
------------------------------------
Teste 3  :
Número de Threads:  500
Numero de tarefas: 100
Tempo de execução:   272 + 271 + 270     
Media: 272 ms
------------------------------------
Teste 4  :
Número de Threads:  1000
Numero de tarefas: 100
Tempo de execução:  269 + 272 + 272    
Media: 271 ms

obs -> no teste 1 O tempo ficou maior no modelo N:M com apenas 10 threads porque o ExecutorService só podia executar 10 tarefas simultaneamente, enquanto as demais aguardavam na fila.
Isso faz com que as tarefas sejam processadas em “lotes”, aumentando o tempo total de execução conforme o número de tarefas cresce.
-------------------------------------------------------------------------------------------------------
Modelo 1:1
Teste 1 :
Número de Threads:  10
Tempo de execução:  259 + 261 + 260    
Media: 260 ms 
-----------------------------------
Teste 2  :
Número de Threads: 50  
Tempo de execução: 265 + 265 + 266       
Media: 265 ms 
-----------------------------------
Teste 3 :
Número de Threads:  500	 
Tempo de execução:  300 + 306 + 302    
Media: 302 ms 
------------------------------------
Teste 4  :
Número de Threads:1000	  
Tempo de execução:  343 + 351 + 344  
Media:346 ms                                              
                 
-------------------------------------------------------------------------------------------------------
Relatório de Comparação de Desempenho entre os Modelos de Thread 1:1 e N:M em Java

O modelo 1:1 é uma forma de mapeamento entre threads de usuário e threads do sistema operacional onde cada thread criada na aplicação corresponde diretamente a uma thread real do sistema. Isso significa que cada tarefa executada tem seu próprio contexto de execução, o que facilita o paralelismo real, mas também aumenta o consumo de recursos (memória e tempo de criação) conforme o número de threads cresce.

Já o modelo N:M utiliza uma estratégia de multiplexação, onde N threads de usuário são distribuídas entre M threads reais. Nesse caso, um número limitado de threads do sistema é responsável por executar várias tarefas, reaproveitando-as através de um pool de threads. Isso reduz o custo de criação e alternância de contexto, melhorando a eficiência em cenários com muitas tarefas.

O objetivo da simulação é comparar a escalabilidade e o desempenho desses dois modelos de execução.
A partir de diferentes quantidades de threads (10, 100, 500 e 1000), pretende-se observar:

O tempo total de execução em cada modelo;

Como o aumento de threads afeta o uso de recursos;

E em que ponto cada modelo se torna mais vantajoso em termos de desempenho e eficiência.
-------------------------------------------------------------------------------------------

 Metodologia:

Linguagem: Java

Tempo medido com System.currentTimeMillis()

Tarefa simulada: Thread.sleep(250)

Execuções com 10, 50, 100, 500 e 1000 threads
-------------------------------------------------------------------------------------------
 Análise Crítica:

O modelo 1:1 tem bom desempenho em poucos threads, pois não há sobrecarga de agendamento.

O modelo N:M se torna mais vantajoso conforme o número de tarefas cresce, pois reutiliza threads do pool.

A partir de certo ponto (ex: 100–200 threads), o 1:1 tende a aumentar o uso de memória e tempo de criação, enquanto o N:M mantém o desempenho mais estável.

O número de threads reais disponíveis no sistema (M) impacta fortemente a performance — se for muito baixo, cria fila de tarefas; se for muito alto, o ganho reduz.
--------------------------------------------------------------------------------------------
Conclusão:

Para poucas tarefas (≤ 50), o modelo 1:1 pode ser suficiente.

Para cargas maiores, o modelo N:M é mais eficiente, com menor overhead.

Virtual Threads (modelo M:N do Project Loom) podem superar ambos, unindo leveza e paralelismo.
