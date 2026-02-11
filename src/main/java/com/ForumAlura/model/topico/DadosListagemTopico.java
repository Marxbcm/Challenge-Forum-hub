package com.ForumAlura.model.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(String titulo, String mensagem, LocalDateTime data, Estado estado, String autor, String curso) {

    public DadosListagemTopico(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getEstado(), topico.getAutor(), topico.getCurso());
    }
}
