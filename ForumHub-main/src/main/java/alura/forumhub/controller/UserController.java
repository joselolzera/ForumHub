package alura.paulo.forumhub.controller;

import alura.paulo.forumhub.domain.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCreateUser dados) {
        repository.save(new User(dados));
    }

    @GetMapping
    public List<DadosListUser> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @PutMapping
    public ResponseEntity<User> atualizarUsuario(@RequestBody @Validated DadosUpdateUser dados) {
        User user = userService.atualizarUsuario(dados);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
