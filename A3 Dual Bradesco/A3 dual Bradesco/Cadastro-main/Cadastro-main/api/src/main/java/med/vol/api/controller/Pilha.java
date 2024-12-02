package med.vol.api.controller;

public class Pilha<T> {
    private Object[] elementos;  // Array para armazenar os elementos
    private int topo = -1;       // Índice do topo da pilha

    public Pilha(int capacidade) {
        // Inicializa o array com a capacidade desejada
        elementos = new Object[capacidade];
    }

    // Método para adicionar um elemento à pilha
    public void push(T elemento) {
        if (topo < elementos.length - 1) {
            elementos[++topo] = elemento;
        } else {
            // Caso a pilha esteja cheia, podemos lançar uma exceção ou expandir
            System.out.println("Pilha cheia!");
        }
    }

    // Método para remover um elemento da pilha
    public T pop() {
        if (topo >= 0) {
            return (T) elementos[topo--];
        }
        return null;  // Se a pilha estiver vazia, retorna null
    }

    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Método para obter o tamanho da pilha
    public int size() {
        return topo + 1;
    }

}
