package BankSBS;

public interface apcaobank {
    void abrirConta(String t);
    public abstract void fecharConta();
    public abstract void depositar(float v);
    public abstract void sacar(float v);
    public abstract void transferir(BankCont bankCont, float v);
    public abstract void emprestimo(String t, float v);
}
