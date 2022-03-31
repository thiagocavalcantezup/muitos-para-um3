package br.com.zup.handora.muitosparaum3.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AlunoController.BASE_URI + "/{alunoId}" + AvaliacaoController.BASE_URI)
public class AvaliacaoController {

    public final static String BASE_URI = "/avaliacoes";

}
