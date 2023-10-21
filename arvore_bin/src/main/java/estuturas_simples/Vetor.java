package main.java.estuturas_simples;

public class Vetor {

    double[] vetor;
    int tamanhoVetor;
    double maior = 0, menor = 1000, nc;

    public Vetor(int tamanho) {

        this.tamanhoVetor = tamanho;
        this.vetor = new double[tamanho];

    }

    public void geraVetor() {
        for (int i = 0; i < vetor.length; i++) {
            double numero = (double) (Math.random() * 1_000);
            double numeroArredondado = Math.round(numero * 1000.0) / 1000.0; // Arredonda para três casas decimais
            vetor[i] = numeroArredondado;
            if(numeroArredondado<menor){
                this.menor = numeroArredondado;
            }else if(numeroArredondado>maior){
                this.maior = numeroArredondado;
            }
        }

        this.vetor = vetor;
    }

    public double[] getVetor() {
        double[] copia = new double[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            copia[i] = vetor[i];
        }

        return copia;
    }

    public int getTamanho() {
        return this.tamanhoVetor;
    }

    public double getValor(int i) {
        return this.vetor[i];
    }

    public void setVetor(double[] vet) {
        this.vetor = vet;
    }

    public void imprimeVetor() {
        System.out.println("");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(i + ": " + vetor[i] + "\n");
        }
    }

    public void imprimeAleatorio() {
        System.out.println("");
        int aleatorio = (int) (Math.random() * this.tamanhoVetor);
        System.out.println(this.vetor[aleatorio] + "\n");

    }

    public double getAleatorio() {
        int aleatorio = (int) (Math.random() * this.vetor.length);
        return vetor[aleatorio];
    }
    
    public double getMenor(){
        return this.menor;
    }
    public double getMaior(){
        return this.maior;
    }
    public double getNaoContem(){
        this.nc = vetor[(tamanhoVetor/2)]+0.001;
        return nc;
    }
}
