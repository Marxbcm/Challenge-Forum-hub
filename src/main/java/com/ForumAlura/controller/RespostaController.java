package com.ForumAlura.controller;

import com.forumAlura.model.resposta.DadosAddResposta;
import com.forumAlura.model.resposta.DadosDetalhamentoResposta;
import com.forumAlura.model.resposta.Resposta;
import com.forumAlura.model.topico.DadosListagemTopico;
import com.forumAlura.repository.RespostaRepository;
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

@RestController
@SecurityRequirement(name = "bearer-key")
@RequestMapping("respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity criarResposta(@RequestBody @Valid DadosAddResposta dados, UriComponentsBuilder uriBuilder) {

        LocalDateTime data = LocalDateTime.now();
        var resposta = new Resposta(dados, data);
        repository.save(resposta);

        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoResposta(resposta));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoResposta>> listar(@PageableDefault(size = 10, sort = {"data"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosDetalhamentoResposta::new);
        return ResponseEntity.ok(page);
    }


}


