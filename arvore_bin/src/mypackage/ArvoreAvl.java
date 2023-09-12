package mypackage;

public class ArvoreAvl {

    private No raiz;
    double tempoCria;

    public ArvoreAvl() {
        this.raiz = null;
    }

    public void setTempoCria(double tempo) {
        this.tempoCria = tempo;
    }

    public double getTempoCria() {
        return this.tempoCria;
    }

    public No getRaiz() {
        return this.raiz;
    }

    private int altura(No no) {
        if (no == null) {
            return 0;
        }
        return no.altura;
    }

    private void atualizarAltura(No no) {
        if (no != null) {
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        }
    }

    private int fatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return altura(no.esquerda) - altura(no.direita);
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    public void inserirAVL(double valor) {
        raiz = inserirAVL(raiz, valor);
    }

    private No inserirAVL(No no, double valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerda = inserirAVL(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirAVL(no.direita, valor);
        } else {
            // Nós duplicados não são permitidos em uma árvore AVL
            return no;
        }

        atualizarAltura(no);

        // Verificar o fator de balanceamento e realizar as rotações necessárias
        int balanceamento = fatorBalanceamento(no);

        // Caso de rotação à direita
        if (balanceamento > 1 && valor < no.esquerda.valor) {
            return rotacaoDireita(no);
        }

        // Caso de rotação à esquerda
        if (balanceamento < -1 && valor > no.direita.valor) {
            return rotacaoEsquerda(no);
        }

        // Caso de rotação dupla à direita
        if (balanceamento > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        // Caso de rotação dupla à esquerda
        if (balanceamento < -1 && valor < no.direita.valor) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

}

class No {

    double valor;
    int altura;
    No esquerda;
    No direita;

    public No(double valor) {
        this.valor = valor;
        this.altura = 1; // A altura inicial de um novo nó é 1
        this.esquerda = null;
        this.direita = null;
    }

    public double getValor() {
        return this.valor;
    }
}
