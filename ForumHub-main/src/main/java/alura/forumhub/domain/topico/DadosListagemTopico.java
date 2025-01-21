package alura.paulo.forumhub.domain.topico;

import alura.paulo.forumhub.domain.curso.DadosListagemCurso;
import alura.paulo.forumhub.domain.user.DadosListUser;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record DadosListagemTopico(
        Long id,
        String titulo,
        String mensagem,
        Status status,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
        Instant dataCriacao,
        DadosListUser user,
        DadosListagemCurso curso
) {
    public DadosListagemTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getStatus(),
                topico.getDataCriacao(),
                new DadosListUser(topico.getUser()),
                new DadosListagemCurso(topico.getCurso()));
    }
}

