package com.example;

public class AnaliseComplexidade {

    private static final int N = 10;

    public static int getN() {
        return N;
    }

    public void tempoCostante(int [] numeros) {
        System.out.println("Primeiro número do vetor: " + numeros[0]);
    }

    public void tempoLogaritmico(int n) {

        int passos = 0;

        int valor = n;

        while (valor > 1) {
            valor = valor / 2;
            passos++;
            
            System.out.println("Passo" + passos + " ->  Valor reduzido para: " + valor);

        }
    }

    public void tempoLinear(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Contando: " + i);
        }
    }

    public void tempoQuadratico(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.println("Contando: " + i);
            
                System.out.println("Par: (" + i + ", " + j + ")");
         }
        }

    }
}
