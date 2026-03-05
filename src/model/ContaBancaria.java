package model;

import interfaces.ControladorConta;

public class ContaBancaria implements ControladorConta {
    private int numeroConta;
    private String titular;
    private double saldo;
    private boolean contaAtiva;

    // Construtor vazio (opcional, dependendo de como você instancia)
    public ContaBancaria() {
        this.saldo = 0.0;
        this.contaAtiva = false;
    }

    // Getters e Setters Necessários
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

    public boolean isContaAtiva() {
        return contaAtiva;
    }

    // Métodos da Interface
    @Override
    public void abrirConta(int numeroConta, String titular) {
        this.setNumeroConta(numeroConta);
        this.setTitular(titular);
        this.saldo = 0.0; // Garantimos que começa com zero aqui
        System.out.println("Conta criada! Número: " + numeroConta + " | Titular: " + titular);
    }

    @Override
    public boolean ativarConta() {
        if (numeroConta <= 0 || titular == null || titular.trim().isEmpty()) {
            System.err.println("Erro: Não é possível ativar uma conta sem número ou titular.");
            return false;
        } else {
            this.contaAtiva = true;
            System.out.println("Conta ativada com sucesso!");
            return true;
        }
    }

    @Override
    public void desativarConta() {
        if (!contaAtiva) {
            System.out.println("A conta já está desativada.");
        } else if (saldo > 0) {
            System.out.println("Erro: Retire o saldo de R$" + saldo + " antes de desativar.");
        } else if (saldo < 0) {
            System.out.println("Erro: Regularize a dívida de R$" + saldo + " antes de desativar.");
        } else {
            this.contaAtiva = false;
            System.out.println("Conta desativada com sucesso.");
        }
    }

    @Override
    public double depositar(double deposito) {
        if (!contaAtiva) {
            throw new IllegalStateException("Impossível depositar: Conta está desativada.");
        }
        if (deposito <= 0) {
            throw new IllegalArgumentException("O valor do depósito deve ser positivo.");
        }
        if (deposito > 10000) {
            System.out.println("Alerta: Depósitos acima de R$10.000 precisam de análise, mas foram processados.");
        }

        this.saldo += deposito;
        System.out.println("Depósito de R$" + deposito + " realizado. Novo saldo: R$" + this.saldo);
        return this.saldo;
    }

    @Override
    public double sacar(double valorSaque) {
        if (!contaAtiva) {
            throw new IllegalStateException("Impossível sacar: Conta está desativada.");
        }
        if (valorSaque <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser maior que zero.");
        }
        if (valorSaque > saldo) {
            // Em vez de só imprimir, lançamos um erro que para o programa ou avisa a Main
            throw new RuntimeException("Saldo insuficiente! Tentativa de saque: " + valorSaque + " | Saldo: " + saldo);
        }

        this.saldo -= valorSaque;
        System.out.println("Saque de R$" + valorSaque + " realizado com sucesso.");
        return this.saldo;
    }

    @Override
    public void mostrarDados() {
        System.out.println("\n===============================");
        System.out.println("       DADOS DA CONTA          ");
        System.out.println("===============================");
        System.out.println("Titular: " + titular);
        System.out.println("Número:  " + numeroConta);
        System.out.println("Saldo:   R$" + saldo);
        System.out.println("Status:  " + (contaAtiva ? "ATIVA" : "INATIVA"));
        System.out.println("===============================\n");
    }
}