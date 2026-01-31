package interfaces;

public interface ControladorConta {

    public void abrirConta(int numeroConta, String titular);

    public void desativarConta();

    public double depositar(double depoisto);

    public double sacar(double valorSaque);

    public void  mostrarDados();

    public boolean ativarConta();
}
