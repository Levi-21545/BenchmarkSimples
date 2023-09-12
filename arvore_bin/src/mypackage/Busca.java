package mypackage;

public final class Busca {

    //double[] vetor;
    ArvoreBinaria arvoreBin;
    ArvoreAvl arvoreBal;
    ArvoreAvlAlt arvoreBalRuim;
    ArvoreBinariaAlt arvoreBinAlt;
    double tempoExecBin;
    double tempoExecBinAlt;
    double tempoExecBal;
    double tempoExecBalRuim;

    public Busca() {

    }

    public double getTempoExecBal() {
        return this.tempoExecBal;
    }

    public double getTempoExecBin() {
        return this.tempoExecBin;
    }

    public double getTempoExecBinAlt() {
        return this.tempoExecBinAlt;
    }

    public double getTempoExecBalRuim() {
        return this.tempoExecBalRuim;
    }

    //ARVORE NORMAL
    public void ArvBin(ArvoreBinaria arvore, double numero) {
        this.arvoreBin = arvore;

        long inicioBusca;
        long fimBusca;

        inicioBusca = System.nanoTime();
        buscaRecArvBin(arvoreBin, numero);
        //System.out.println("Terminou");
        fimBusca = System.nanoTime();

        double tempoSort = (double) (fimBusca - inicioBusca) / 1_000_000;

        this.tempoExecBin = tempoSort;
    }

    public boolean buscaRecArvBin(ArvoreBinaria arvore, double numero) {
        if (arvore.getRaiz() == null) {
            System.out.println("Nao achou raiz null");
            return false; // Valor não encontrado
        }

        if (numero == arvore.getRaiz().getDado().getValor()) {
            System.out.println(Cores.GREEN + "Achou Bmain" + Cores.RESET);
            return true; // Valor encontrado
        }

        if (numero < arvore.getRaiz().getDado().getValor()) {
            if (arvore.arvoreEsquerda != null) {
                return buscaRecArvBin(arvore.arvoreEsquerda, numero);
            } else {
                System.out.println("Nao achou esquerda");
                return false; // Elemento não encontrado na subárvore esquerda
            }
        } else {
            if (arvore.arvoreDireita != null) {
                return buscaRecArvBin(arvore.arvoreDireita, numero);
            } else {
                //arvore.direita.pos_ordem();
                System.out.println("Nao achou direita");
                return false; // Elemento não encontrado na subárvore direita
            }
        }
    }

    //ARVORE BALANCEADA
    public void ArvBal(ArvoreAvl arvore, double numero) {
        this.arvoreBal = arvore;

        long inicioBusca;
        long fimBusca;

        inicioBusca = System.nanoTime();
        buscaRecArvBal(arvoreBal.getRaiz(), numero);
        //System.out.println("Terminou");
        fimBusca = System.nanoTime();

        double tempoSort = (double) (fimBusca - inicioBusca) / 1_000_000;

        this.tempoExecBal = tempoSort;
    }

    public boolean buscaRecArvBal(No no, double numero) {
        if (no == null) {
            System.out.println("Nao achou raiz null avl");
            return false; // Valor não encontrado
        }
        if (numero == no.getValor()) {
            System.out.println(Cores.GREEN + "Achou AVL" + Cores.RESET);
            return true; // Valor encontrado
        }

        if (numero < no.getValor()) {
            return buscaRecArvBal(no.esquerda, numero);
        } else {
            return buscaRecArvBal(no.direita, numero);
        }
    }

    //ARVORE BALANCEADA RUIM
    public void ArvBalRuim(ArvoreAvlAlt arvore, double numero) {
        this.arvoreBalRuim = arvore;

        long inicioBusca;
        long fimBusca;

        inicioBusca = System.nanoTime();
        buscaRecArvBalRuim(arvoreBalRuim.getRaiz(), numero);
        //System.out.println("Terminou");
        fimBusca = System.nanoTime();

        double tempoSort = (double) (fimBusca - inicioBusca) / 1_000_000;

        this.tempoExecBalRuim = tempoSort;
    }

    public boolean buscaRecArvBalRuim(ArvoreAvlAlt.No arvore, double numero) {
        if (arvore == null) {
            System.out.println("Nao achou raiz null");
            return false; // Valor não encontrado
        }
        if (numero == arvore.getChave()) {
            System.out.println(Cores.GREEN + "Achou AVL Ruim" + Cores.RESET);
            return true; // Valor encontrado
        }

        if (numero < arvore.getChave()) {
            if (arvore.getEsquerda() != null) {
                return buscaRecArvBalRuim(arvore.getEsquerda(), numero);
            } else {
                //System.out.println("Nao achou esquerda");
                return false; // Elemento não encontrado na subárvore esquerda
            }
        } else {
            if (arvore.getDireita() != null) {
                return buscaRecArvBalRuim(arvore.getDireita(), numero);
            } else {
                //arvore.getArvoreDireita().pos_ordem();
                // System.out.println("Nao achou direita");
                return false; // Elemento não encontrado na subárvore direita
            }
        }
    }

    //ARVORE BINARIA RUIM
    public void ArvBinAlt(ArvoreBinariaAlt arvore, double numero) {
        this.arvoreBinAlt = arvore;

        long inicioBusca;
        long fimBusca;

        inicioBusca = System.nanoTime();
        buscaRecArvBinAlt(arvoreBinAlt, numero);
        fimBusca = System.nanoTime();

        double tempoSort = (double) (fimBusca - inicioBusca) / 1_000_000;

        this.tempoExecBinAlt = tempoSort;
    }

    public boolean buscaRecArvBinAlt(ArvoreBinariaAlt arvore, double numero) {
        if (arvore.getRaiz() == null) {
            System.out.println("Raiz bin ruim null");

            return false; // se arvore vazia
        }
        NoArvBin atual = arvore.getRaiz();  // começa a procurar desde raiz
        while (atual.getItem() != numero) { // enquanto nao encontrou
            if (numero < atual.item) {
                atual = atual.esq; // caminha para esquerda
            } else {
                atual = atual.dir; // caminha para direita
            }
            if (atual == null) {

                return false; // encontrou uma folha -> sai
            }
        } // fim laço while

            System.out.println(Cores.GREEN + "Achou Bin Ruim" + Cores.RESET);
        return true; // terminou o laço while e ch
    }

}
