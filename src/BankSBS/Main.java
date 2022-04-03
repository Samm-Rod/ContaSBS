package BankSBS;

public class Main {
    public static void main(String[] args) {
        BankCont joao = new BankCont();
        BankCont maria = new BankCont();

        joao.setDono("Joao");
        joao.setNumCont(1111);
        maria.setDono("Maria");
        maria.setNumCont(2222);

        joao.abrirConta("cp");
        maria.abrirConta("cp");

        joao.depositar(2530.75f);
        maria.depositar(3325.90f);
        joao.transferir(maria,450.60f);
        maria.transferir(joao,1553.50f);

        joao.estratoCont();
        maria.estratoCont();



    }
}
