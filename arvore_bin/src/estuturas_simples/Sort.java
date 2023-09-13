package estuturas_simples;

public class Sort {

    double[] vetor;
    double tempoExecucao;

    public Sort(Vetor vetor) {

        this.vetor = vetor.getVetor();

    }

    public double getTempoExecucao() {
        return this.tempoExecucao;
    }

    public void imprimeVetor() {
        System.out.println("");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(i + ": " + vetor[i] + "\n");
        }
    }

    //BUBBLE SORT
    public void ordenaBubble() {
        long inicioSort;
        long fimSort;

        inicioSort = System.nanoTime();
        for (int t = 0; t < vetor.length; t++) {
            for (int i = 0; i < (vetor.length - 1); i++) {
                if (vetor[i] > vetor[i + 1]) {
                    double r = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = r;
                }
            }
        }
        fimSort = System.nanoTime();
        System.out.println("Sort: Ordenou Bubble");

        double tempoSort = (double) (fimSort - inicioSort) / 1_000_000;

        //System.out.print("Tempo total: " + tempoSort + "ms\n");
        //return tempoSort;
        this.tempoExecucao = tempoSort;
    }

    //SELECTION SORT
    public void ordenaSelection() {
        long inicioSort;
        long fimSort;

        inicioSort = System.nanoTime();
        for (int o = 0; o < vetor.length; o++) {
            double menor = vetor[o];
            for (int i = o; i < vetor.length; i++) {
                if (menor > vetor[i]) {
                    menor = vetor[i]; //¹
                    double r = vetor[o];
                    vetor[o] = menor;
                    vetor[i] = r;
                }
            }
        }
        fimSort = System.nanoTime();
        double tempoSort = (double) (fimSort - inicioSort) / 1_000_000;

        System.out.println("Sort: Ordenou Selection");

        //System.out.print("Tempo total: " + tempoSort + "ms\n");
        this.tempoExecucao = tempoSort;
    }

    //INSERTION SORT
    public void ordenaInsertion() {
        long inicioSort;
        long fimSort;

        inicioSort = System.nanoTime();
        int j;
        double n;
        for (int i = 1; i < vetor.length; i++) {
            n = vetor[i];
            j = i - 1;

            while (j >= 0 && vetor[j] > n) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = n;
        }
        fimSort = System.nanoTime();
        double tempoSort = (double) (fimSort - inicioSort) / 1_000_000;

        System.out.println("Sort: Ordenou Insertion");

        //System.out.print("Tempo total: " + tempoSort + "ms\n");
        this.tempoExecucao = tempoSort;
    }

    //QUICK SORT
    public void ordenaQuick() {
        long inicioSort;
        long fimSort;

        inicioSort = System.nanoTime();
        quickSort(this.vetor, 0, vetor.length - 1);
        fimSort = System.nanoTime();
        double tempoSort = (double) (fimSort - inicioSort) / 1_000_000;

        System.out.println("Sort: Ordenou Quick");

        //System.out.print("Tempo total: " + tempoSort + "ms\n");
        this.tempoExecucao = tempoSort;

    }

    private void quickSort(double[] vetor, int o, int fim) {
        if (o < fim) {
            int p = separar(vetor, o, fim);
            quickSort(vetor, o, p - 1);
            quickSort(vetor, p + 1, fim);
        }
    }

    private int separar(double[] vetor, int inicio, int fim) {
        double pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                double troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }

}