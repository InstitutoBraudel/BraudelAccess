package br.org.braudel.braudel.controllers;


import br.org.braudel.braudel.models.alunos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;


    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroAlunosDTO dados){

        alunoRepository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<ListagemAlunosDTO> listar(@PageableDefault(size = 10, sort = {"nome"})Pageable pageable){
        return alunoRepository.findByAtivoTrue(pageable).map(ListagemAlunosDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarAluno dados){
        var aluno = alunoRepository.getReferenceById(dados.id());
        aluno.atualizarInfromacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var aluno = alunoRepository.getReferenceById(id);
        aluno.excluir();
    }
}
