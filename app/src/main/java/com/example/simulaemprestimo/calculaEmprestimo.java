package com.example.simulaemprestimo;

public class calculaEmprestimo {
    private double valorEmprestimo;
    private int numParcelas;
    private double taxaJuros;
    private double salarioCliente;

    //Criando o método construtor
    public calculaEmprestimo(double valorEmprestimo, int numParcelas, double taxaJuros, double salarioCliente) {
        this.valorEmprestimo = valorEmprestimo;
        this.numParcelas = numParcelas;
        this.taxaJuros = taxaJuros/100;
        this.salarioCliente = salarioCliente;
    }
    //calcula o valor da parcela do empréstimo utilizando a fórmula para cálculo de juros compostos
    public double calcularParcela() {
        double valorParcela = valorEmprestimo * Math.pow(1 + taxaJuros, numParcelas) * taxaJuros / (Math.pow(1 + taxaJuros, numParcelas) - 1);
        return valorParcela;
    }
    //calcula o valor total da dívida em um determinado mês, novamente utilizando a fórmula para cálculo de juros compostos.
    public double calcularTotalDivida(int mes) {
        double valorDivida = valorEmprestimo * Math.pow(1 + taxaJuros, mes);
        return valorDivida;
    }
    //verifica se o empréstimo pode ser concedido de acordo com a regra de que o valor da parcela não pode ser superior a 30% do salário do cliente
    public boolean podeConcederEmprestimo() {
        double valorParcela = calcularParcela();
        double percentualSalario = (valorParcela / salarioCliente) * 100;
        return percentualSalario <=30;
    }
}
