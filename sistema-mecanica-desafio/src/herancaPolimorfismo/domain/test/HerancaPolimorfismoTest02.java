package herancaPolimorfismo.domain.test;

import herancaPolimorfismo.domain.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class HerancaPolimorfismoTest02 {
    public static void main(String[] args) {
        // ---------- 1. Cadastro ----------
        Proprietario rafael = new Proprietario("Rafael", "10982873784");
        Proprietario bagley = new Proprietario("Bagley", "12394873555");

        List<Veiculo> veiculos = new ArrayList<>();
        veiculos.add(new Carro("FW8717", "Ferraro", Year.of(2012), 30000, rafael, TipoCombustivel.GASOLINA));
        veiculos.add(new Moto("JKW788", "Fazer", Year.of(2015), 20000, rafael, TipoCombustivel.GASOLINA));
        veiculos.add(new Caminhao("QW7T8V", "Mercedes", Year.of(2017), 60000, bagley, TipoCombustivel.DIESEL, 4000));
        veiculos.add(new Carro("QYT83C", "Tesla", Year.of(2020), 2000, bagley, TipoCombustivel.ELETRICO));

        // Associação: completa o lado do Proprietario depois que os veiculos existem
        List<Veiculo> veiculosRafael = new ArrayList<>();
        List<Veiculo> veiculosBagley = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getProprietario() == rafael) {
                veiculosRafael.add(veiculo);
            } else {
                veiculosBagley.add(veiculo);
            }
        }
        rafael.setVeiculos(veiculosRafael);
        bagley.setVeiculos(veiculosBagley);

        System.out.println();
        System.out.println("=========== OFICINA MECANICA - RELATORIO GERAL ===========");
        System.out.println("Total de veiculos cadastrados (static): " + Veiculo.getTotalVeiculosCadastrados());

        // ---------- 2. Fichas (metodo final) ----------
        System.out.println("\n--- 1) FICHA DOS VEICULOS (metodo final) ---");
        for (Veiculo veiculo : veiculos) {
            System.out.print(veiculo.getClass().getSimpleName() + " -> ");
            veiculo.exibirDadosBasicos();
        }

        // ---------- 3. Polimorfismo + sobrecarga + enum ----------
        System.out.println("\n--- 2) REVISOES (polimorfismo + sobrecarga + enum) ---");
        System.out.printf("%-10s %-8s %-10s %-10s %10s %10s%n",
                "Tipo", "Placa", "Modelo", "Combust.", "Simples", "Completa");
        double totalGeral = 0;
        for (Veiculo veiculo : veiculos) {
            double simples = veiculo.calcularValorRevisao();
            double completa = veiculo.calcularValorRevisao(true);
            totalGeral += completa;
            System.out.printf("%-10s %-8s %-10s %-10s %10.2f %10.2f%n",
                    veiculo.getClass().getSimpleName(),
                    veiculo.getPlaca(),
                    veiculo.getModelo(),
                    veiculo.getTipoCombustivel().NOME_RELATORIO,
                    simples,
                    completa);
        }
        System.out.printf("Total (revisoes completas): R$ %.2f%n", totalGeral);

        // ---------- 4. Interface ----------
        System.out.println("\n--- 3) MANUTENCAO (interface Manutenivel) ---");
        for (Manutenivel manutenivel : veiculos) {
            manutenivel.realizarManutencao();
        }

        // ---------- 5. Associacao ----------
        System.out.println("\n--- 4) VEICULOS POR PROPRIETARIO (associacao) ---");
        for (Proprietario proprietario : List.of(rafael, bagley)) {
            double gasto = 0;
            System.out.println(proprietario.getNome() + " (CPF " + proprietario.getCpf() + ")");
            for (Veiculo veiculo : proprietario.getVeiculos()) {
                gasto += veiculo.calcularValorRevisao();
                System.out.println("   - " + veiculo);
            }
            System.out.printf("   Gasto com revisoes simples: R$ %.2f%n", gasto);
        }

        // ---------- 6. instanceof ----------
        System.out.println("\n--- 5) ATRIBUTOS ESPECIFICOS (instanceof + cast) ---");
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Caminhao) {
                Caminhao caminhao = (Caminhao) veiculo;
                System.out.println(caminhao.getModelo() + " e um caminhao de " + caminhao.getPeso() + " kg");
            }
        }

        // ---------- 7. Enum ----------
        System.out.println("\n--- 6) TIPOS DE COMBUSTIVEL (enum) ---");
        for (TipoCombustivel tipo : TipoCombustivel.values()) {
            long quantidade = 0;
            for (Veiculo veiculo : veiculos) {
                if (veiculo.getTipoCombustivel() == tipo) {
                    quantidade++;
                }
            }
            System.out.println(tipo.VALOR + " - " + tipo.NOME_RELATORIO + ": " + quantidade + " veiculo(s)");
        }
        System.out.println("==========================================================");
    }
}
