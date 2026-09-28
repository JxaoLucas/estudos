package fundamentos.domain;

import java.time.Year;

public class Veiculo {
    private String placa;
    private String modelo;
    private Year ano;
    private int quilometragem;
    private Proprietario proprietario;
    private static int totalVeiculosCadastrados;

    static {
        System.out.println("Sistema de Oficina iniciado");
    }

    public Veiculo(String placa, String modelo, Year ano, int quilometragem, Proprietario proprietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.proprietario = proprietario;
        totalVeiculosCadastrados++;
    }

    public Veiculo(String placa, String modelo, Proprietario proprietario) {
        this(placa, modelo, Year.now(), 0, proprietario);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Year getAno() {
        return ano;
    }

    public void setAno(Year ano) {
        this.ano = ano;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public static int getTotalVeiculosCadastrados() {
        return totalVeiculosCadastrados;
    }

    public double calcularValorRevisao(){
        double valorRevisao = 100;

        if (getQuilometragem() > 20000) {
            valorRevisao += valorRevisao * 0.15;
            return valorRevisao;
        }

        valorRevisao += valorRevisao * 0.1;
        return valorRevisao;
    }

    public double calcularValorRevisao(boolean isRevisaoCompleta){
        double valorRevisao = calcularValorRevisao();

        if(isRevisaoCompleta){
            valorRevisao += valorRevisao * 0.50;
        }

        return valorRevisao;
    }

    @Override
    public String toString() {
        return modelo;
    }


}
