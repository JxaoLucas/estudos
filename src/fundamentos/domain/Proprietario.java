package fundamentos.domain;

import java.util.Arrays;

public class Proprietario {
    private String nome;
    private String cpf;
    private Veiculo[] veiculos;

    public Proprietario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Proprietario(String nome, String cpf, Veiculo[] veiculos) {
        this.nome = nome;
        this.cpf = cpf;
        this.veiculos = veiculos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Veiculo[] getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculo[] veiculos){
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return nome;
    }
}
