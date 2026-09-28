package herancaPolimorfismo.domain;

public enum TipoCombustivel {
    GASOLINA(1, "Gasolina"),
    ETANOL(2, "Etanol"),
    DIESEL(3, "Diesel"),
    ELETRICO(4, "Elétrico");

    public final int VALOR;
    public final String NOME_RELATORIO;

    TipoCombustivel(int VALOR, String NOME_RELATORIO) {
        this.VALOR = VALOR;
        this.NOME_RELATORIO = NOME_RELATORIO;
    }
}
