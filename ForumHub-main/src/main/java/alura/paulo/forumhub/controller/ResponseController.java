package alura.paulo.forumhub.controller;

import alura.paulo.forumhub.domain.response.DadosCadastroResponse;
import alura.paulo.forumhub.domain.response.DadosListagemResponse;
import alura.paulo.forumhub.domain.response.Response;
import alura.paulo.forumhub.domain.response.ResponseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resposta")
public class ResponseController {

    @Autowired
    private ResponseService respostaService;

    @PostMapping
    public ResponseEntity<DadosListagemResponse> cadastrar(@RequestBody @Valid DadosCadastroResponse dados) {
        Response resposta = respostaService.cadastrar(dados);
        return ResponseEntity.ok(new DadosListagemResponse(resposta));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemResponse>> listar() {
        List<DadosListagemResponse> respostas = respostaService.listar();
        return ResponseEntity.ok(respostas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        respostaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

