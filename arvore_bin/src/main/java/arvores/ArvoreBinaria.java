package main.java.arvores;

public class ArvoreBinaria {

    public NoBin raiz;
    public ArvoreBinaria arvoreEsquerda;
    public ArvoreBinaria arvoreDireita;
    double tempoCria;

    public ArvoreBinaria() {
    }

    public void setTempoCria(double tempo) {
        this.tempoCria = tempo;
    }

    public double getTempoCria() {
        return this.tempoCria;
    }

    public NoBin getRaiz() {
        return raiz;
    }

    public void setRaiz(NoBin raiz) {
        this.raiz = raiz;
    }

    public ArvoreBinaria getArvoreDireita() {
        return arvoreDireita;
    }

    public void setArvoreDireita(ArvoreBinaria arvoreDir) {
        this.arvoreDireita = arvoreDir;
    }

    public ArvoreBinaria getArvoreEsquerda() {
        return arvoreEsquerda;
    }

    public void setArvoreEsquerda(ArvoreBinaria arvoreEsq) {
        this.arvoreEsquerda = arvoreEsq;
    }

    public class NoBin {

        private Dado dado;

        public NoBin(Dado dado) {
            this.dado = dado;
        }

        public Dado getDado() {
            return dado;
        }

        public void setDado(Dado dado) {
            this.dado = dado;
        }
    }

    public class Dado {

        private double valor;

        public Dado(double valor) {
            this.valor = valor;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
    }

    ///MÉTODOS PARA PERCORRER
    public void pre_ordem() {
        if (this.raiz == null) {
            return;
        }

        System.out.println("Valor: " + this.raiz.getDado().getValor());

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.pre_ordem();
        }
        if (this.arvoreDireita != null) {
            this.arvoreDireita.pre_ordem();
        }
    }

    public void em_ordem() {
        if (this.raiz == null) {
            return;
        }

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.em_ordem();
        }

        System.out.println("Valor: " + this.raiz.getDado().getValor());

        if (this.arvoreDireita != null) {
            this.arvoreDireita.em_ordem();
        }
    }

    public void pos_ordem() {
        if (this.raiz == null) {
            return;
        }

        if (this.arvoreEsquerda != null) {
            this.arvoreEsquerda.pos_ordem();
        }

        if (this.arvoreDireita != null) {
            this.arvoreDireita.pos_ordem();
        }

        System.out.println("Valor: " + this.raiz.getDado().getValor());
    }

    ///MÉTODOS PARA INSERIR E REMOVER
    public void inserir_binaria(double valor) {
        Dado dado = new Dado(valor);
        NoBin no = new NoBin(dado);
        inserir(no);
    }

    public void inserir(NoBin no) {
        if (this.raiz == null) {
            this.raiz = no;
        } else {
            // SE VALOR INSERIDO É MENOR QUE RAIZ
            if (no.getDado().getValor() < this.raiz.getDado().getValor()) {
                if (this.arvoreEsquerda == null) {
                    this.arvoreEsquerda = new ArvoreBinaria();
                }
                this.arvoreEsquerda.inserir(no);
            } else if (no.getDado().getValor() > this.raiz.getDado().getValor()) {
                if (this.arvoreDireita == null) {
                    this.arvoreDireita = new ArvoreBinaria();
                }
                this.arvoreDireita.inserir(no);
            } else {
                //System.out.println("Elemento ja existente");
            }
        }
        //this.pre_ordem();
    }

    public static ArvoreBinaria remover_binaria(ArvoreBinaria aux, int num) {
        ArvoreBinaria p, p2;

        if (aux.raiz.getDado().getValor() == num) {
            if (aux.arvoreEsquerda == aux.arvoreDireita) {
                return null;
            } else if (aux.arvoreEsquerda == null) {
                return aux.arvoreDireita;
            } else if (aux.arvoreDireita == null) {
                return aux.arvoreEsquerda;
            } else {
                p2 = aux.arvoreDireita;
                p = aux.arvoreDireita;
                while (p.arvoreEsquerda != null) {
                    p = p.arvoreEsquerda;
                }
                p.arvoreEsquerda = aux.arvoreEsquerda;
                return p2;
            }
        } else if (aux.raiz.getDado().getValor() < num) {
            aux.arvoreDireita = remover_binaria(aux.arvoreDireita, num);
        } else {
            aux.arvoreEsquerda = remover_binaria(aux.arvoreEsquerda, num);
        }
        return aux;
    }

}
