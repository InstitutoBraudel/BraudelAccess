package br.org.braudel.braudel.models.alunos;

public record ListagemAlunosDTO(Long id, String nome, String idade, String escola, String telefone, Boolean multiplicador, String semestreMultiplicador ) {
    public ListagemAlunosDTO(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getEscola(), aluno.getTelefone(), aluno.getMultiplicador(), aluno.getSemestreMultiplicador());
    }
}
