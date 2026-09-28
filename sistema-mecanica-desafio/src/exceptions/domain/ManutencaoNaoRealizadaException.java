package exceptions.domain;

public class ManutencaoNaoRealizadaException extends RuntimeException {
    public ManutencaoNaoRealizadaException(String message) {
        super(message);
    }
}
