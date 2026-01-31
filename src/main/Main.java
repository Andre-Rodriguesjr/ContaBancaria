package main;
import model.ContaBancaria; 

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContaBancaria b = new ContaBancaria();

        b.abrirConta(1, "André");
        b.ativarConta();
        b.depositar(100);
        b.depositar(100);
        b.mostrarDados();

    }
}