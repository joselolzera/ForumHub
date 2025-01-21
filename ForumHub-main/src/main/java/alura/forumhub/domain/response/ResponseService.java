package alura.paulo.forumhub.domain.response;

import alura.paulo.forumhub.domain.topico.Topico;
import alura.paulo.forumhub.domain.topico.TopicoRepository;
import alura.paulo.forumhub.domain.user.User;
import alura.paulo.forumhub.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public Response cadastrar(DadosCadastroResponse dados) {
        Optional<User> autorOpt = userRepository.findById(dados.autorId());
        Optional<Topico> topicoOpt = topicoRepository.findById(dados.topicoId());

        if (autorOpt.isPresent() && topicoOpt.isPresent()) {
            User autor = autorOpt.get();
            Topico topico = topicoOpt.get();
            Response response = new Response(dados, autor, topico);
            return responseRepository.save(response);
        }

        throw new IllegalArgumentException("Autor ou Tópico não encontrado");
    }

    public List<DadosListagemResponse> listar() {
        return responseRepository.findAll().stream().map(DadosListagemResponse::new).toList();
    }

    public void deletar(Long id) {
        responseRepository.deleteById(id);
    }
}
