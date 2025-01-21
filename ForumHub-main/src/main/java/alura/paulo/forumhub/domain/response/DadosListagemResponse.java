package alura.paulo.forumhub.domain.response;



import alura.paulo.forumhub.domain.topico.DadosListagemTopico;
import alura.paulo.forumhub.domain.user.DadosListUser;

import java.time.Instant;

public record DadosListagemResponse(
        Long id,
        String mensagem,
        Instant dataCriacao,
        Boolean solucao,
        DadosListUser autor,
        DadosListagemTopico topico
) {
    public DadosListagemResponse(Response response) {
        this(
                response.getId(),
                response.getMensagem(),
                response.getDataCriacao(),
                response.getSolucao(),
                new DadosListUser(response.getAutor()),
                new DadosListagemTopico(response.getTopico())
        );
    }
}
