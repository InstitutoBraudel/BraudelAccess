package br.org.braudel.braudel.controllers;


import br.org.braudel.braudel.models.professores.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroProfessoresDTO dados){
        professorRepository.save(new Professores(dados));
    }

    @GetMapping
    public Page<ListagemProfessoresDTO> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable pageable){
        return professorRepository.findByAtivoTrue(pageable).map(ListagemProfessoresDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarProfessor dados){
        var professor = professorRepository.getReferenceById(dados.id());
        professor.atualizarInfromacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var professor = professorRepository.getReferenceById(id);
        professor.excluir();
    }
}
