package com.example;

public class Main {
    public static void main(String[] args) {

        AnaliseComplexidade analise = new AnaliseComplexidade();

        int[] numeros = {1, 2, 3, 4, 5};
        analise.tempoCostante(numeros);
        analise.tempoLogaritmico(AnaliseComplexidade.getN());
        analise.tempoLinear(5);
        analise.tempoQuadratico(3);

    }
}