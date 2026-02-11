package com.ForumAlura.model.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private Estado estado;
    private String autor;
    private String curso;

    public Topico(DadosAddTopico dados, LocalDateTime data) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = data;
        this.estado = Estado.Ativo;
        this.autor = dados.autor();
        this.curso = dados.curso();
    }

    public void atualizarDados(DadosAddTopico dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
    }
}
