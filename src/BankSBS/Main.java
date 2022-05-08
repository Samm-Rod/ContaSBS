package BankSBS;

public class Main {
    public static void main(String[] args) {
        BankCont joao = new BankCont();
        BankCont maria = new BankCont();

        joao.setDono("Joao");
        joao.setNumCont(1111);
        maria.setDono("Maria");
        maria.setNumCont(2222);
        joao.abrirConta("cc");
        joao.emprestimo(joao,1500);


        joao.estratoCont();
        maria.estratoCont();



    }
}
