package br.com.zup.handora.muitosparaum3.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.handora.muitosparaum3.repositories.AlunoRepository;
import br.com.zup.handora.muitosparaum3.repositories.AvaliacaoRepository;

@RestController
@RequestMapping(AlunoController.BASE_URI + "/{alunoId}" + AvaliacaoController.BASE_URI)
public class AvaliacaoController {

    public final static String BASE_URI = "/avaliacoes";

    private final AlunoRepository alunoRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoController(AlunoRepository alunoRepository,
                               AvaliacaoRepository avaliacaoRepository) {
        this.alunoRepository = alunoRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

}
