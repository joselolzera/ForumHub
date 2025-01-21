package alura.paulo.forumhub.domain.topico;


import alura.paulo.forumhub.domain.curso.Curso;
import alura.paulo.forumhub.domain.user.User;
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
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    @Column(name = "data_criacao", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Instant dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    public Topico(DadosCadastroTopico dados, User user, Curso curso) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.status = dados.status();
        this.dataCriacao = dados.dataCriacao() != null ? dados.dataCriacao() : Instant.now();
        this.user = user;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Status getStatus() {
        return status;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public User getUser() {
        return user;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
