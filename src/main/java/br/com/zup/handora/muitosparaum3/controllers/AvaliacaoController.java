package br.com.zup.handora.muitosparaum3.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.muitosparaum3.models.Aluno;
import br.com.zup.handora.muitosparaum3.models.Avaliacao;
import br.com.zup.handora.muitosparaum3.models.AvaliacaoDTO;
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

    @PostMapping
    public ResponseEntity<Void> create(@PathVariable Long alunoId,
                                       @RequestBody @Valid AvaliacaoDTO avaliacaoDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {
        Aluno aluno = alunoRepository.findById(alunoId)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe um aluno com o ID fornecido."
                                         )
                                     );
        Avaliacao avaliacao = avaliacaoRepository.save(avaliacaoDTO.paraAvaliacao(aluno));

        URI location = uriComponentsBuilder.path(
            AlunoController.BASE_URI + "/{alunoId}" + BASE_URI + "/{id}"
        ).buildAndExpand(aluno.getId(), avaliacao.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
