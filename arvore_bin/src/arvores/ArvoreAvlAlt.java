package arvores;

import java.util.ArrayList;

public class ArvoreAvlAlt {

    protected NoAvlAlt raiz;
    protected double tempoCria;

    public NoAvlAlt getRaiz() {
        return this.raiz;
    }
    
    public void setTempoCria(double tempo){
        this.tempoCria = tempo;
    }
    public double getTempoCria(){
        return this.tempoCria;
    }

    public void inserir(double k) {
        NoAvlAlt n = new NoAvlAlt(k);
        inserirAVL(this.raiz, n);
    }

    public void inserirAVL(NoAvlAlt aComparar, NoAvlAlt aInserir) {

        if (aComparar == null) {
            this.raiz = aInserir;

        } else {

            if (aInserir.getChave() < aComparar.getChave()) {

                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getEsquerda(), aInserir);
                }

            } else if (aInserir.getChave() > aComparar.getChave()) {

                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getDireita(), aInserir);
                }

            } else {
                // O nó já existe
            }
        }
    }

    public void verificarBalanceamento(NoAvlAlt atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2) {

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);

            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }

        } else if (balanceamento == 2) {

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);

            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }

    public void remover(int k) {
        removerAVL(this.raiz, k);
    }

    public void removerAVL(NoAvlAlt atual, int k) {
        if (atual == null) {
            return;

        } else {

            if (atual.getChave() > k) {
                removerAVL(atual.getEsquerda(), k);

            } else if (atual.getChave() < k) {
                removerAVL(atual.getDireita(), k);

            } else if (atual.getChave() == k) {
                removerNoEncontrado(atual);
            }
        }
    }

    public void removerNoEncontrado(NoAvlAlt aRemover) {
        NoAvlAlt r;

        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

            if (aRemover.getPai() == null) {
                this.raiz = null;
                aRemover = null;
                return;
            }
            r = aRemover;

        } else {
            r = sucessor(aRemover);
            aRemover.setChave(r.getChave());
        }

        NoAvlAlt p;
        if (r.getEsquerda() != null) {
            p = r.getEsquerda();
        } else {
            p = r.getDireita();
        }

        if (p != null) {
            p.setPai(r.getPai());
        }

        if (r.getPai() == null) {
            this.raiz = p;
        } else {
            if (r == r.getPai().getEsquerda()) {
                r.getPai().setEsquerda(p);
            } else {
                r.getPai().setDireita(p);
            }
            verificarBalanceamento(r.getPai());
        }
        r = null;
    }

    public NoAvlAlt rotacaoEsquerda(NoAvlAlt inicial) {

        NoAvlAlt direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    public NoAvlAlt rotacaoDireita(NoAvlAlt inicial) {

        NoAvlAlt esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    public NoAvlAlt duplaRotacaoEsquerdaDireita(NoAvlAlt inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    public NoAvlAlt duplaRotacaoDireitaEsquerda(NoAvlAlt inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    public NoAvlAlt sucessor(NoAvlAlt q) {
        if (q.getDireita() != null) {
            NoAvlAlt r = q.getDireita();
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
            return r;
        } else {
            NoAvlAlt p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    private int altura(NoAvlAlt atual) {
        if (atual == null) {
            return -1;
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;

        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    private void setBalanceamento(NoAvlAlt no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    final protected ArrayList<NoAvlAlt> inorder() {
        ArrayList<NoAvlAlt> ret = new ArrayList<NoAvlAlt>();
        inorder(raiz, ret);
        return ret;
    }

    final protected void inorder(NoAvlAlt no, ArrayList<NoAvlAlt> lista) {
        if (no == null) {
            return;
        }
        inorder(no.getEsquerda(), lista);
        lista.add(no);
        inorder(no.getDireita(), lista);
    }

    public class NoAvlAlt {

        private NoAvlAlt esquerda;
        private NoAvlAlt direita;
        private NoAvlAlt pai;
        private double chave;
        private int balanceamento;

        public NoAvlAlt(double k) {
            setEsquerda(setDireita(setPai(null)));
            setBalanceamento(0);
            setChave(k);
        }

        public String toString() {
            return Double.toString(getChave());
        }

        public double getChave() {
            return chave;
        }

        public void setChave(double chave) {
            this.chave = chave;
        }

        public int getBalanceamento() {
            return balanceamento;
        }

        public void setBalanceamento(int balanceamento) {
            this.balanceamento = balanceamento;
        }

        public NoAvlAlt getPai() {
            return pai;
        }

        public NoAvlAlt setPai(NoAvlAlt pai) {
            this.pai = pai;
            return pai;
        }

        public NoAvlAlt getDireita() {
            return direita;
        }

        public NoAvlAlt setDireita(NoAvlAlt direita) {
            this.direita = direita;
            return direita;
        }

        public NoAvlAlt getEsquerda() {
            return esquerda;
        }

        public void setEsquerda(NoAvlAlt esquerda) {
            this.esquerda = esquerda;
        }
    }

}
