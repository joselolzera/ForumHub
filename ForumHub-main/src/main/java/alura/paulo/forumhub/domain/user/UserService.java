package alura.paulo.forumhub.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository usuarioRepository;


    public List<DadosListUser> listarUsuarios() {
        List<User> users = usuarioRepository.findAll();
        return users.stream()
                .map(DadosListUser::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public User cadastrar(DadosCreateUser dados) {
        var usuario = new User(dados);
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public User atualizarUsuario(DadosUpdateUser dados) {
        User user = usuarioRepository.findById(dados.id())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        user.atualizar(dados);
        return usuarioRepository.save(user);
    }

    @Transactional
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }


}
