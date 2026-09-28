package herancaPolimorfismo.domain;

import java.time.Year;

public class Moto extends Veiculo{
    public Moto(String placa, String modelo, Year ano, int quilometragem, Proprietario proprietario, TipoCombustivel tipoCombustivel) {
        super(placa, modelo, ano, quilometragem, proprietario, tipoCombustivel);
    }

    @Override
    public double calcularValorRevisao(){
        double valorRevisao = 65;

        if (getQuilometragem() > 20000) {
            valorRevisao += valorRevisao * 0.20;
            return valorRevisao;
        }

        valorRevisao += valorRevisao * 0.15;
        return valorRevisao;
    }
}
