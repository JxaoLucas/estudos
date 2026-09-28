package exceptions.domain;

import java.util.List;

public class Proprietario {
    private String nome;
    private String cpf;
    private List<Veiculo> veiculos;

    public Proprietario(String nome, String cpf, List<Veiculo> veiculos) {
        this.nome = nome;
        this.cpf = cpf;
        this.veiculos = veiculos;
    }

    public Proprietario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return nome;
    }
}
