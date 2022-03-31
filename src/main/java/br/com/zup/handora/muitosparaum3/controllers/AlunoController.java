package br.com.zup.handora.muitosparaum3.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.handora.muitosparaum3.repositories.AlunoRepository;

@RestController
@RequestMapping(AlunoController.BASE_URI)
public class AlunoController {

    public final static String BASE_URI = "/alunos";

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

}
