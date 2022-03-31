package br.com.zup.handora.muitosparaum3.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.muitosparaum3.models.Aluno;
import br.com.zup.handora.muitosparaum3.models.AlunoDTO;
import br.com.zup.handora.muitosparaum3.repositories.AlunoRepository;

@RestController
@RequestMapping(AlunoController.BASE_URI)
public class AlunoController {

    public final static String BASE_URI = "/alunos";

    private final AlunoRepository alunoRepository;

    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid AlunoDTO alunoDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {
        Aluno aluno = alunoRepository.save(alunoDTO.paraAluno());

        URI location = uriComponentsBuilder.path(BASE_URI + "/{id}")
                                           .buildAndExpand(aluno.getId())
                                           .toUri();

        return ResponseEntity.created(location).build();
    }

}
