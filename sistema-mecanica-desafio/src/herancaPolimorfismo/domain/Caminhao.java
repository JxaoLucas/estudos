package herancaPolimorfismo.domain;

import java.time.Year;

public class Caminhao extends Veiculo{
    private double peso;

    public Caminhao(String placa, String modelo, Year ano, int quilometragem, Proprietario proprietario, TipoCombustivel tipoCombustivel, double peso) {
        super(placa, modelo, ano, quilometragem, proprietario, tipoCombustivel);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public double calcularValorRevisao(){
        double valorRevisao = 150;

        if(getPeso() > 3000){
            valorRevisao += valorRevisao * 0.05;
        }

        if (getQuilometragem() > 20000) {
            valorRevisao += valorRevisao * 0.20;
            return valorRevisao;
        }

        valorRevisao += valorRevisao * 0.15;
        return valorRevisao;
    }
}
