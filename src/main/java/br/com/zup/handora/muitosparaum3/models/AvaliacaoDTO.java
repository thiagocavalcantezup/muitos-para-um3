package br.com.zup.handora.muitosparaum3.models;

import javax.validation.constraints.NotBlank;

public class AvaliacaoDTO {

    @NotBlank
    private String titulo;

    @NotBlank
    private String atividade;

    public AvaliacaoDTO() {}

    public AvaliacaoDTO(@NotBlank String titulo, @NotBlank String atividade) {
        this.titulo = titulo;
        this.atividade = atividade;
    }

    public Avaliacao paraAvaliacao(Aluno aluno) {
        return new Avaliacao(titulo, atividade, aluno);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAtividade() {
        return atividade;
    }

}
