package mypackage;

class criaArvBinThread implements Runnable {

    mypackage.Vetor vetor;
    ArvoreBinaria arvoreBin;

    public criaArvBinThread(ArvoreBinaria arvoreBin, mypackage.Vetor vetor) {
        this.vetor = vetor;
        this.arvoreBin = arvoreBin;
    }

    @Override
    public void run() {
        long inicioBusca;
        long fimBusca;

        System.out.println(Cores.YELLOW + "Tree: Criando Arvore Binaria..." + Cores.RESET);

        inicioBusca = System.nanoTime();
        for (int i = 0; i < vetor.getTamanho(); i++) {
            arvoreBin.inserir_binaria(vetor.getValor(i));
        }
        fimBusca = System.nanoTime();

        double tempoCria = (double) (fimBusca - inicioBusca) / 1_000_000;
        arvoreBin.setTempoCria(tempoCria);

        System.out.println(Cores.GREEN + "Tree: Arvore Binaria sucesso!" + Cores.RESET);

    }

}

class criaArvBinAltThread implements Runnable {

    Vetor vetor;
    ArvoreBinariaAlt arvoreBinAlt;

    public criaArvBinAltThread(ArvoreBinariaAlt arvoreBinAlt, Vetor vetor) {
        this.vetor = vetor;
        this.arvoreBinAlt = arvoreBinAlt;
    }

    @Override
    public void run() {
        long inicioBusca;
        long fimBusca;

        System.out.println(Cores.YELLOW + "Tree: Criando Arvore Binaria Alt..." + Cores.RESET);

        inicioBusca = System.nanoTime();
        for (int i = 0; i < vetor.getTamanho(); i++) {
            arvoreBinAlt.inserir(vetor.getValor(i));
        }
        fimBusca = System.nanoTime();

        double tempoCria = (double) (fimBusca - inicioBusca) / 1_000_000;
        arvoreBinAlt.setTempoCria(tempoCria);

        System.out.println(Cores.GREEN + "Tree: Arvore Binaria Alt sucesso!" + Cores.RESET);

    }

}

class criaArvBalThread implements Runnable {

    Vetor vetor;
    ArvoreAvl arvoreBal;

    public criaArvBalThread(ArvoreAvl arvoreBal, Vetor vetor) {
        this.vetor = vetor;
        this.arvoreBal = arvoreBal;
    }

    @Override
    public void run() {
        long inicioBusca;
        long fimBusca;

        System.out.println(Cores.YELLOW + "Tree: Criando Arvore Balanceada..." + Cores.RESET);

        inicioBusca = System.nanoTime();
        for (int i = 0; i < vetor.getTamanho(); i++) {
            arvoreBal.inserirAVL(vetor.getValor(i));
        }
        fimBusca = System.nanoTime();

        double tempoCria = (double) (fimBusca - inicioBusca) / 1_000_000;
        arvoreBal.setTempoCria(tempoCria);

        System.out.println(Cores.GREEN + "Tree: Arvore Balanceada sucesso!" + Cores.RESET);
    }

}

class criaArvBalRuimThread implements Runnable {

    Vetor vetor;
    ArvoreAvlAlt arvoreBalRuim;

    public criaArvBalRuimThread(ArvoreAvlAlt arvoreBalRuim, Vetor vetor) {
        this.vetor = vetor;
        this.arvoreBalRuim = arvoreBalRuim;
    }

    @Override
    public void run() {
        long inicioBusca;
        long fimBusca;

        System.out.println(Cores.YELLOW + "Tree: Criando Arvore Balanceada Ruim..." + Cores.RESET);

        inicioBusca = System.nanoTime();
        for (int i = 0; i < vetor.getTamanho(); i++) {
            arvoreBalRuim.inserir(vetor.getValor(i));
        }
        fimBusca = System.nanoTime();

        double tempoCria = (double) (fimBusca - inicioBusca) / 1_000_000;
        arvoreBalRuim.setTempoCria(tempoCria);

        System.out.println(Cores.GREEN + "Tree: Arvore Balanceada Ruim sucesso!" + Cores.RESET);
    }

}
