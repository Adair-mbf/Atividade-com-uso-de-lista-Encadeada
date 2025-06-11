public class ListaDuplamenteEncadeada {
    No inicio;
    No fim;

    void limpar(){
        this.inicio = null;
        this.fim = null;
    }
    void exibirDecrescente(){
        No atual = this.fim;
        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.anterior;
        }
        System.out.print("\n");
    }
    void exibir(){
        No atual = this.inicio;
        while(atual != null){
            System.out.println(atual.valor);
            atual = atual.proximo;
        }
        System.out.print("\n");
    }
    void inserirEm(int indice, int valor) {
        No novoNo = new No(valor);

        if (indice <= 0 || this.inicio == null) {
            novoNo.proximo = this.inicio;
            if (this.inicio != null) {
                this.inicio.anterior = novoNo;
            } else {
                this.fim = novoNo;
            }
            this.inicio = novoNo;
            return;
        }

        No atual = this.inicio;
        int i = 0;

        while (atual != null && i < indice - 1) {
            atual = atual.proximo;
            i++;
        }

        if (atual == null || atual.proximo == null) {
            this.fim.proximo = novoNo;
            novoNo.anterior = this.fim;
            this.fim = novoNo;
        }
        else {
            novoNo.proximo = atual.proximo;
            novoNo.anterior = atual;
            atual.proximo.anterior = novoNo;
            atual.proximo = novoNo;
        }
    }
    void removerEm(int indice) {
        if (this.inicio == null || indice < 0) {
            return;
        }

        No atual = this.inicio;
        int i = 0;

        while (atual != null && i < indice) {
            atual = atual.proximo;
            i++;
        }

        if (atual == null) {
            return;
        }

        if (atual.anterior != null) {
            atual.anterior.proximo = atual.proximo;
        } else {
            this.inicio = atual.proximo;
        }

        if (atual.proximo != null) {
            atual.proximo.anterior = atual.anterior;
        } else {
            this.fim = atual.anterior;
        }
    }
    void inserirCrescente(int valor){
        No novoNo = new No(valor);
        if(this.inicio == null){
            this.inicio = novoNo;
            this.fim = novoNo;
        }
        else{
            this.fim.proximo = novoNo;
            novoNo.anterior = this.fim;
            this.fim = novoNo;
        }
    }
    void remover(int valor){
        No atual = this.inicio;
        while(atual != null){
            if(atual.valor == valor){
                if(atual.anterior != null){
                    atual.anterior.proximo = atual.proximo;
                }
                else{
                    this.inicio = atual.proximo;
                }
                if(atual.proximo != null){
                    atual.proximo.anterior = atual.anterior;
                }
                else{
                    this.fim = atual.anterior;
                }
                atual = null;
                return;
            }
            atual = atual.proximo;
        }
    }
    void exibirTamanho(){
        int tamanho = 0;
        No atual = this.inicio;
        while (atual != null) {
            tamanho++;
            atual = atual.proximo;
        }
        System.out.println("A lista contém: " + tamanho + " posições");
        System.out.print("\n");
    }
    void inserirDecrescente(int valor) {
        No novoNo = new No(valor);

        if (this.inicio == null) {
            this.inicio = novoNo;
            this.fim = novoNo;
            return;
        }

        No atual = this.inicio;
        while (atual != null && atual.valor > valor) {
            atual = atual.proximo;
        }

        if (atual == null) {
            this.fim.proximo = novoNo;
            novoNo.anterior = this.fim;
            this.fim = novoNo;
        }
        else if (atual == this.inicio) {
            novoNo.proximo = this.inicio;
            this.inicio.anterior = novoNo;
            this.inicio = novoNo;
        }
        else {
            novoNo.proximo = atual;
            novoNo.anterior = atual.anterior;
            atual.anterior.proximo = novoNo;
            atual.anterior = novoNo;
        }
    }
    void removerPrimos() {
        No atual = this.inicio;

        while (atual != null) {
            No proximo = atual.proximo;

            if (ehPrimo(atual.valor)) {
                if (atual.anterior != null) {
                    atual.anterior.proximo = atual.proximo;
                } else {
                    this.inicio = atual.proximo;
                }

                if (atual.proximo != null) {
                    atual.proximo.anterior = atual.anterior;
                } else {
                    this.fim = atual.anterior;
                }
            }

            atual = proximo;
        }
    }
    boolean ehPrimo(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

}
