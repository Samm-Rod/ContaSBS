package BankSBS;

public class InterfaceBank {
    public static void main(String[] args) {
        BankCont joao = new BankCont();
        BankCont maria = new BankCont();

        joao.setDono("Joao");
        joao.setNumCont(1111);
        maria.setDono("Maria");
        maria.setNumCont(2222);

        joao.abrirConta("cp");
        joao.depositar(100.00f);
        maria.abrirConta("cc");
        maria.depositar(100.00f);
        joao.transferir(maria,50);
        maria.transferir(joao,120.50f);

        joao.estratoCont();
        maria.estratoCont();



    }
}
