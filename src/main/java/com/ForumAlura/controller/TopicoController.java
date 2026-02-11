package com.ForumAlura.controller;

import com.forumAlura.model.topico.DadosAddTopico;
import com.forumAlura.model.topico.DadosDetalhamentoTopico;
import com.forumAlura.model.topico.DadosListagemTopico;
import com.forumAlura.model.topico.Topico;
import com.forumAlura.repository.TopicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity criarTopico(@RequestBody @Valid DadosAddTopico dados, UriComponentsBuilder uriBuilder) {

        LocalDateTime data = LocalDateTime.now();
        var topico = new Topico(dados, data);
        repository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"data"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemTopico::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAddTopico dados) {

        Optional<Topico> topico = repository.findById(id);

        if (topico.isPresent()) {
            var topicoAtt = repository.getReferenceById(id);
            topicoAtt.atualizarDados(dados);
            return ResponseEntity.ok(new DadosDetalhamentoTopico(topicoAtt));
        } else {
            return ResponseEntity.noContent().build();
        }


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        Optional<Topico> topico = repository.findById(id);

        if (topico.isPresent()) {

            repository.deleteById(id);
            return ResponseEntity.ok("id " + id + " deletado");

        } else {

            return ResponseEntity.noContent().build();
        }
    }


    @GetMapping("/teste")
    public void olaMundo(){
        System.out.println("olá mundo");

    }


}


