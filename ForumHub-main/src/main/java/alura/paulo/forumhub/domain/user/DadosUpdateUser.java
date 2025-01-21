package alura.paulo.forumhub.domain.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosUpdateUser(

        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotBlank
        String email,

        String senha,

        @NotNull
        Boolean status
) {
}
