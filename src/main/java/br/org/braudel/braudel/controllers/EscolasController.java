package br.org.braudel.braudel.controllers;


import br.org.braudel.braudel.models.escolas.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("escolas")
public class EscolasController {
    @Autowired
    private EscolaRepository escolaRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastroEscolasDTO dados){
        escolaRepository.save(new Escolas(dados));
    }

    @GetMapping
    public Page<ListagemEscolasDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return escolaRepository.findByAtivoTrue(pageable).map(ListagemEscolasDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizarEscola dados){
        var escolas = escolaRepository.getReferenceById(dados.id());
        escolas.atualizarInfromacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var escolas = escolaRepository.getReferenceById(id);
        escolas.excluir();
    }
}
