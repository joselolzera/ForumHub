package alura.paulo.forumhub.controller;

import alura.paulo.forumhub.domain.curso.Curso;
import alura.paulo.forumhub.domain.curso.CursoService;
import alura.paulo.forumhub.domain.curso.DadosCadastroCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @PostMapping
    public ResponseEntity<Curso> criarCurso(@RequestBody @Validated DadosCadastroCurso dados) {
        Curso curso = cursoService.criarCurso(dados);
        return new ResponseEntity<>(curso, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.noContent().build();
    }

}
