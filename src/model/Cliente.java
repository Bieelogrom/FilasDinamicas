package model;

public class Cliente {
    private int numero;
    private String nome;
    private boolean prioritario;

    public Cliente(int numero, String nome, boolean prioritario){
        this.numero = numero;
        this.nome = nome;
        this.prioritario = prioritario;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setPrioritario(boolean prioritario){
        this.prioritario = prioritario;
    }

    public boolean getPrioritario(){
        return this.prioritario;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numero=" + numero +
                ", nome='" + nome + '\'' +
                ", prioritario=" + prioritario +
                '}';
    }
}
