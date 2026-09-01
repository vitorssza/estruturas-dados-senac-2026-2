package com.example;

public class Main {
    public static void main(String[] args) {

        double[] faturamentos = {20.0, 30.0, 50.0, 10.0, 40.0};

        for (int i = 0; i < faturamentos.length; i++) {
            System.out.print("\nFaturamentos: " + faturamentos[i]);
        }

        double soma = 0.0;
        double maiorValor = faturamentos[0];
        double menorValor = faturamentos[0];
        int indiceMaior = 0;
        int indiceMenor = 0;

        for (int i = 0; i < faturamentos.length; i++) {
            soma += faturamentos[i];
        }

        for (int i = 0; i < faturamentos.length; i++) {
            if (faturamentos[i] > maiorValor) {
                maiorValor = faturamentos[i];
                indiceMaior = i;
            }

            if (faturamentos[i] < menorValor) {
                menorValor = faturamentos[i];
                indiceMenor = i;
            }
        }

        double media = soma / faturamentos.length;

        System.out.println();
        System.out.println("\n- Soma dos faturamentos: " + soma);
        System.out.println("\n- Media por caixa: " + media);
        System.out.println("\n- Caixa com maior venda - Caixa: " + (indiceMaior + 1) + ", Venda: " + maiorValor);
        System.out.println("\n- Caixa com menor venda - Caixa: " + (indiceMenor + 1) + ", Venda: " + menorValor);

        for (int i = 0; i < faturamentos.length; i++) {
            if (faturamentos[i] > media) {
                System.out.println("\n- Caixas acima da media: " + i);
            }
        }
    }
}

