package br.org.braudel.braudel.models.professores;

import br.org.braudel.braudel.models.alunos.Aluno;

public record ListagemProfessoresDTO(Long id, String nome, String idade, String escola, String telefone, String disciplina, String tempoParticipacaoCL ) {
    public ListagemProfessoresDTO(Professores professores){
        this(professores.getId(), professores.getNome(), professores.getIdade(), professores.getEscola(), professores.getTelefone(), professores.getDisciplina(), professores.getTempoParticipacaoCL());
    }
}
