package BankSBS;

import java.util.Scanner;

public class BankCont implements apcaobank {
    private int numCont;
    private String dono;
    private String tipo;
    private float saldo;
    private boolean status;
    private BankCont bank;


    //   Metodo
    public void estratoCont(){
        if(this.getStatus()){
            System.out.println("Numero da conta : "+this.getNumCont());
            System.out.println("Dono : "+this.getDono());
            System.out.println("Tipo : "+this.getTipo());
            System.out.println("Saldo Disponível : "+this.getSaldo());
            System.out.println("----------------- Estrato da conta --------------------");
        }

    }


//  Construtor
    public BankCont() {
        super();
        this.numCont = numCont;
        this.tipo = tipo;
        this.saldo = 0;
        this.status = false;
    }

    //Getters
    public int getNumCont(){
        return numCont;
    }
    public String getTipo(){
        return tipo;
    }
    public float getSaldo(){
        return saldo;
    }
    public boolean getStatus(){
        return status;
    }
    public BankCont getBank() {
        return getBank();
    }
    public String getDono(){
        return dono;
    }

    //Setters
    public void setNumCont(int nc){
        this.numCont = nc;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }
    public void setStatus(boolean status){
        this.status = status;
    }

    public void setDono(String dono){
        this.dono = dono;
    }

    //Metodos implements
    @Override
    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if(t == "cd"){
            this.setSaldo(50);
            System.out.println("Conta Débito aberta, saldo dispónivel de R$"+this.getSaldo());
        }else if(t == "cc"){
            this.setSaldo(100);
            System.out.println("Conta Corrente aberta, saldo dispónivel de R$"+this.getSaldo());
        }
        System.out.println("Conta aberta!");
    }

    @Override
    public void fecharConta() {
        if(this.getStatus()){
            if(this.getSaldo() > 0){
                System.out.println("Saldo de R$"+this.getSaldo()+" em conta, não pode ser encerrado");
            }else if(this.getSaldo() < 0){
                System.out.println("Conta em débito de R$"+this.getSaldo()+", impossível encerrar");
            }else{
                this.setStatus(false);
                System.out.println("Conta encerrada!");
            }

        }
    }

    @Override
    public void depositar(float v) {
        if(this.getStatus()){
            this.setSaldo(this.getSaldo() + v);
            System.out.println("Deposito de R$"+v+" na conta de "+this.getDono());
        }else{
            System.out.println("Conta fechada ");
        }
    }

    @Override
    public void sacar(float v) {
        if(this.getStatus()){
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Saque com sucesso R$"+v+" na conta de "+this.getDono());
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public void transferir(BankCont bank, float v) {
        if(this.getStatus() && this.getSaldo() > 0){
            this.setSaldo(this.getSaldo() - v);
            bank.setSaldo(bank.getSaldo() + v);
            System.out.println("Transferência de R$"+v+" com sucesso");
        }else{
            System.out.println("Saldo insulficiente");
        }
    }


    @Override
     public void emprestimo(BankCont bank, float salt) {
        System.out.println("Informe a sua quantia desejada: ");
        Scanner vl = new Scanner(System.in);
        float val = vl.nextFloat();
        float parcel = val * 30/100;
        if(bank.getTipo() == "cc" && parcel <= salt){
            this.setSaldo(this.getSaldo() + val);
        } else{
            System.out.println("Emprestimo concedido apenas aos correntistas");
        }
    }

    @Override
    public void cobrarValor() {

    }

}
