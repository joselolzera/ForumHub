package alura.paulo.forumhub.domain.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroResponse(

        @NotBlank
        String mensagem,

        @NotNull
        Boolean solucao,

        @NotNull
        Long autorId,

        @NotNull
        Long topicoId
) {
}
