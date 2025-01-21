package alura.paulo.forumhub.domain.response;

import alura.paulo.forumhub.domain.user.User;
import alura.paulo.forumhub.domain.topico.Topico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "respostas")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    @Column(name = "data_criacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant dataCriacao;

    private Boolean solucao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private User autor;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public Response(DadosCadastroResponse dados, User autor, Topico topico) {
        this.mensagem = dados.mensagem();
        this.solucao = dados.solucao();
        this.dataCriacao = Instant.now();
        this.autor = autor;
        this.topico = topico;
    }

    public Long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public Boolean getSolucao() {
        return solucao;
    }

    public User getAutor() {
        return autor;
    }

    public Topico getTopico() {
        return topico;
    }
}
