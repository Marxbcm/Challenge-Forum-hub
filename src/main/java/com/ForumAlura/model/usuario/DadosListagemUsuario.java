package com.ForumAlura.model.usuario;

public record DadosListagemUsuario(Long id, String login) {

    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin());
    }
}
