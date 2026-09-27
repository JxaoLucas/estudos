package fundamentos.domain.test;

import fundamentos.domain.Proprietario;
import fundamentos.domain.Veiculo;

import java.time.Year;
import java.util.Arrays;

public class FundamentosTest01 {
    public static void main(String[] args) {
        Proprietario proprietario1 = new Proprietario("Rafael", "10982873784");

        Veiculo veiculo1 = new Veiculo("27W4700", "Ferrari", Year.of(2002), 21000, proprietario1);
        Veiculo veiculo2 = new Veiculo("48W4722", "Lamborghini", Year.of(2012), 6000, proprietario1);

        Veiculo[] veiculosProprietario1 = {veiculo1, veiculo2};
        proprietario1.setVeiculos(veiculosProprietario1);

        System.out.println("=======================================================");
        System.out.println("Proprietario 1");
        System.out.println("Nome: " + proprietario1.getNome());
        System.out.println("cpf: " + proprietario1.getCpf());
        System.out.println("Veiculos: " + Arrays.toString(proprietario1.getVeiculos()));
        System.out.println("=======================================================");
        System.out.println("Veiculo 1");
        System.out.println("placa: " + veiculo1.getPlaca());
        System.out.println("Modelo: " + veiculo1.getModelo());
        System.out.println("Ano: " + veiculo1.getAno());
        System.out.println("Quilometragem: " + veiculo1.getQuilometragem());
        System.out.println("Proprietario: " + veiculo1.getProprietario());
        System.out.println("Valor revisao simples: " + veiculo1.calcularValorRevisao());
        System.out.println("Valor revisao completa: " + veiculo1.calcularValorRevisao(true));
        System.out.println("--------------------------------------------------------");
        System.out.println("Veiculo 2");
        System.out.println("placa: " + veiculo2.getPlaca());
        System.out.println("Modelo: " + veiculo2.getModelo());
        System.out.println("Ano: " + veiculo2.getAno());
        System.out.println("Quilometragem: " + veiculo2.getQuilometragem());
        System.out.println("Proprietario: " + veiculo2.getProprietario());
        System.out.println("Valor revisao simples: " + veiculo2.calcularValorRevisao());
        System.out.println("Valor revisao completa: " + veiculo2.calcularValorRevisao(true));
        System.out.println("=======================================================");
        System.out.println("Total de veiculos cadastrados: " + Veiculo.getTotalVeiculosCadastrados());
    }
}
