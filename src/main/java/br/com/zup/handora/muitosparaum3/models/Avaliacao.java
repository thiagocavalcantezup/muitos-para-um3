package br.com.zup.handora.muitosparaum3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    @Lob
    private String atividade;

    @ManyToOne(optional = false)
    Aluno aluno;

    /**
     * @deprecated Construtor de uso exclusivo do Hibernate
     */
    @Deprecated
    public Avaliacao() {}

    public Avaliacao(String titulo, String atividade, Aluno aluno) {
        this.titulo = titulo;
        this.atividade = atividade;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

}
