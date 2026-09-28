package herancaPolimorfismo.domain;

import java.time.Year;

public abstract class Veiculo implements Manutenivel{
    private final String placa;
    private String modelo;
    private Year ano;
    private int quilometragem;
    private Proprietario proprietario;
    private static int totalVeiculosCadastrados;
    private TipoCombustivel tipoCombustivel;

    static {
        System.out.println("Sistema de Oficina iniciado");
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Realizando manutenção");
    }

    public Veiculo(String placa, String modelo, Year ano, int quilometragem, Proprietario proprietario, TipoCombustivel tipoCombustivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.proprietario = proprietario;
        totalVeiculosCadastrados++;
        this.tipoCombustivel = tipoCombustivel;
    }

    public Veiculo(String placa, String modelo, Proprietario proprietario) {
        this(placa, modelo, Year.now(), 0, proprietario, null);
    }

    public String getPlaca() {
        return placa;
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

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public final void exibirDadosBasicos() {
        System.out.println("Placa: " + placa + " | Modelo: " + modelo + " | Ano: " + ano + " | Km: " + quilometragem);
    }

    public abstract double calcularValorRevisao();

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
