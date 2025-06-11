public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        int [] vetor = new int[1000];
        System.out.println("Números gerados em ordem: ");
        for(int i = 0; i < vetor.length; i++){
            int numeroGerado = (int)(Math.random()*19999) - 9999;
            vetor[i] = numeroGerado;
            System.out.println(numeroGerado);
        }
        System.out.print("\n");
        MergeSort.mergeSort(vetor, 0, vetor.length - 1);

        for(int i = 0; i < vetor.length; i++){
            lista.inserirCrescente(vetor[i]);
        }
        System.out.println("Lista: ");
        lista.exibir();

        System.out.print("\n");

        System.out.println("Lista decrescente: ");
        lista.exibirDecrescente();

        System.out.print("\n");

        lista.removerPrimos();

        System.out.println("Lista sem números primos: ");
        lista.exibir();

        System.out.print("\n");

    }
}