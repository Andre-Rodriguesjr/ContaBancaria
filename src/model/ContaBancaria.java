package model;

import interfaces.ControladorConta;

public class ContaBancaria implements ControladorConta {
    private int numeroConta;
    private String titular;
    private double saldo;
    private boolean contaAtiva;



    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isContaAtiva() {
        return contaAtiva;
    }

    public void setContaAtiva(boolean contaAtiva) {
        this.contaAtiva = contaAtiva;
    }

    @Override
    public void abrirConta(int numeroConta, String titular) {
        this.setNumeroConta(numeroConta);
        this.setTitular(titular);
        System.out.println("Conta aberta com sucesso. Número: " + numeroConta + ", Titular: " + titular);
    }

    @Override
    public boolean ativarConta() {

        this.saldo = 0;
        if (numeroConta < 0 || titular == null || titular.trim().isEmpty()) {
            System.out.println("Erro: Dados incompletos. Informe número E titular para ativar.");
            return false;
        } else {
            this.contaAtiva = true;
            System.out.println("Conta ativada com sucesso!!");
            return true;
        }
    }

    @Override
    public void desativarConta() {
        if (!contaAtiva) {
            System.out.println("A conta já está desativada");
        } else if (saldo > 0) {
            System.out.println("Saque o dinheiro antes de fechar a conta");
        } else if (saldo < 0) {
            System.out.println("A conta está endividada, pague a dívida antes de fechar.");
        } else {
            contaAtiva = false;
            System.out.println("Conta fechada com sucesso");
        }
    }

    @Override
    public double depositar(double deposito) {
        
        if (contaAtiva == false) {
            System.out.println("Não é possivel depositar em conta desativada");
        } else if (deposito > 10000) {
            System.out.println("Valor muito alto, deposite um valor menor!!");
        } else {
            this.saldo += deposito;
            System.out.println("Deposito no valor de: " + deposito + " realizado com sucesso.");

        }
        return this.saldo;
    }

    @Override
    public double sacar(double valorSaque) {

        if (!contaAtiva){
            System.out.println("Não é possivel sacar em uma conta desativada");
        } else if (valorSaque > saldo){
            System.out.println("Não é possivel sacar um valor maior que o saldo!!");
        } else if (valorSaque<=0) {
            System.out.println("Não é possivel sacar 0 reais ou valores negativos");
        }else {
            this.saldo -= valorSaque;
        }
        return this.saldo;
    }

    @Override
    public void mostrarDados() {
        System.out.println("========DADOS DA CONTA ==========");
        System.out.println("Numero da conta: " + numeroConta);
        System.out.println("Nome do titular: " + titular);
        System.out.println("Saldo da conta: " + saldo);
        System.out.println("A conta está ativa?: " + contaAtiva);
    }
}
