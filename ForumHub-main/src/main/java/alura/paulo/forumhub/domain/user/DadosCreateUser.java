package alura.paulo.forumhub.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCreateUser(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        String senha,

        @NotNull
        Boolean status) {
}
