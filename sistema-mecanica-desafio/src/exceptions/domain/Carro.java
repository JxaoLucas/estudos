package exceptions.domain;

import java.time.Year;

public class Carro extends Veiculo {
    public Carro(String placa, String modelo, Year ano, int quilometragem, Proprietario proprietario, TipoCombustivel tipoCombustivel) throws PlacaInvalidaException {
        super(placa, modelo, ano, quilometragem, proprietario, tipoCombustivel);
    }

    @Override
    public double calcularValorRevisao() {
        double valorRevisao = 100;

        if (getQuilometragem() > 20000) {
            valorRevisao += valorRevisao * 0.15;
            return valorRevisao;
        }

        valorRevisao += valorRevisao * 0.1;
        return valorRevisao;
    }
}
