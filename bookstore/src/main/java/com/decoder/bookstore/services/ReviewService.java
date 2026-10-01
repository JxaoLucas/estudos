package com.decoder.bookstore.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ChatClient chatClient;

    public ReviewService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String generateReview(String bookTitle) {
        try {
            String prompt = """
                    Com base apenas no seu próprio conhecimento, forneça um resumo objetivo e direto do livro "%s".
                    Regras:
                    - Não inclua opiniões ou avaliações pessoais.
                    - Não repita o título do livro na resposta.
                    - A resposta deve ser em português.
                    - A resposta deve ter no máximo 500 caracteres.
                    """.formatted(bookTitle);

            String review = chatClient.prompt()
                    .user(prompt)
                    .call()
                    .content();

            if (review == null) {
                return null;
            }
            return review.length() > 500 ? review.substring(0, 500) : review;
        } catch (Exception e) {
            System.out.println("Erro ao gerar review para o livro \"" + bookTitle + "\": " + e.getMessage() + " — esse erro precisa ser tratado.");
            // Aqui caberia o tratamento adequado: envio para fila de erro, retentativa ou circuit breaker.
            return null;
        }
    }
}
