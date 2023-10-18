package estuturas_simples;

import java.util.ArrayList;
import java.util.List;

public class Sort {

    double[] vetor;
    double tempoExecucao;
    boolean registrar;
    public List<String> registros = new ArrayList();

    public Sort(Vetor vetor) {

        this.vetor = vetor.getVetor();
        this.registrar = false;
    }

    public double getTempoExecucao() {
        return this.tempoExecucao;
    }

    public void setTempoExecucao(double tempoExec) {
        this.tempoExecucao = tempoExec;
    }

    public void setRegistrar(boolean registrar) {
        this.registrar = registrar;
    }

    public void imprimeVetor() {
        System.out.println("");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(i + ": " + vetor[i] + "\n");
        }
    }

    //BUBBLE SORT
    public void ordenaBubble() {
        long inicioSort = 0;
        long fimSort = 0;
        registros.clear();

        if (registrar == true) {
            for (int t = 0; t < vetor.length; t++) {
                for (int i = 0; i < (vetor.length - 1); i++) {
                    registraPasso();

                    if (vetor[i] > vetor[i + 1]) {
                        double r = vetor[i];
                        vetor[i] = vetor[i + 1];
                        vetor[i + 1] = r;
                    }
                }
            }
            System.out.println("Sort: Ordenou Bubble");
        } else {
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
        }

        double tempoSort = (double) (fimSort - inicioSort) / 1_000_000;

        //System.out.print("Tempo total: " + tempoSort + "ms\n");
        //return tempoSort;
        this.tempoExecucao = tempoSort;
    }

    //SELECTION SORT
    public void ordenaSelection() {
        long inicioSort;
        long fimSort;
        registros.clear();

        if (registrar == true) {
            for (int o = 0; o < vetor.length; o++) {
                double menor = vetor[o];
                for (int i = o; i < vetor.length; i++) {
                    registraPasso();

                    if (menor > vetor[i]) {
                        menor = vetor[i];
                        double r = vetor[o];
                        vetor[o] = menor;
                        vetor[i] = r;
                    }
                }
            }
        } else {
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
            this.tempoExecucao = tempoSort;
        }
        //System.out.print("Tempo total: " + tempoSort + "ms\n");
    }

    //INSERTION SORT
    public void ordenaInsertion() {
        long inicioSort;
        long fimSort;
        registros.clear();

        if (registrar == true) {
            int j;
            double n;
            for (int i = 1; i < vetor.length; i++) {
                registraPasso();

                n = vetor[i];
                j = i - 1;
                while (j >= 0 && vetor[j] > n) {
                    vetor[j + 1] = vetor[j];
                    j = j - 1;
                }
                vetor[j + 1] = n;
            }
        } else {
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
            this.tempoExecucao = tempoSort;

        }

        System.out.println("Sort: Ordenou Insertion");

        //System.out.print("Tempo total: " + tempoSort + "ms\n");
    }

    //QUICK SORT
    public void ordenaQuick() {
        long inicioSort;
        long fimSort;
        registros.clear();

        if (registrar == true) {
            quickSortReg(this.vetor, 0, vetor.length - 1);

        } else {
            inicioSort = System.nanoTime();
            quickSort(this.vetor, 0, vetor.length - 1);
            fimSort = System.nanoTime();
            double tempoSort = (double) (fimSort - inicioSort) / 1_000_000;

            this.tempoExecucao = tempoSort;

        }

        System.out.println("Sort: Ordenou Quick");

        //System.out.print("Tempo total: " + tempoSort + "ms\n");
    }

    private void quickSort(double[] vetor, int o, int fim) {
        if (o < fim) {
            int p = separar(vetor, o, fim);
            quickSort(vetor, o, p - 1);
            quickSort(vetor, p + 1, fim);
        }
    }

    private void quickSortReg(double[] vetor, int o, int fim) {
        if (o < fim) {
            registraPasso();

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

    private void registraPasso() {
        // Converte o vetor em uma string
        StringBuilder values = new StringBuilder("{");
        for (int i = 0; i < vetor.length; i++) {
            int numero = (int) vetor[i];
            //double numeroArredondado = Math.round(numero * 1.0) / 1.0;

            values.append(numero);
            if (i < vetor.length - 1) {
                values.append(", ");
            }
        }
        values.append("}");

        // Adiciona a string à lista de registros
        try {
            if (!registros.get(registros.size() - 1).equals(values.toString())) {
                registros.add(values.toString());
            }
        } catch (IndexOutOfBoundsException e) {
            registros.add(values.toString());
        }

    }
}
