package com.ForumAlura.model.resposta;

import com.ForumAlura.model.topico.Estado;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respostas")
@Entity(name = "Resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mensagem;

    private String topico;
    private LocalDateTime data;

    private String autor;

    public Resposta(@Valid DadosAddResposta dados, LocalDateTime data) {
        this.mensagem = dados.mensagem();
        this.data = data;
        this.topico = dados.topico();
        this.autor = dados.autor();
    }

}
