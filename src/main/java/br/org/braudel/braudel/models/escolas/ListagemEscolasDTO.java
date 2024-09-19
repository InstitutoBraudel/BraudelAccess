package br.org.braudel.braudel.models.escolas;

import br.org.braudel.braudel.models.alunos.Aluno;

public record ListagemEscolasDTO(Long id, String nomeInstituticao, String telefoneEscola, String email, String nomeCoordPedago, String emailCoordPedago, String telefoneCoordPedago, String alunosParticipantesCL, String professoresParticipantesCL, String vinculacaoEscola) {
    public ListagemEscolasDTO(Escolas escolas){
        this(escolas.getId(), escolas.getNomeInstituticao(), escolas.getTelefoneEscola(), escolas.getEmail(), escolas.getNomeCoordPedago(), escolas.getEmailCoordPedago(), escolas.getTelefoneCoordPedago(), escolas.getAlunosParticipantesCL(), escolas.getProfessoresParticipantesCL(), escolas.getVinculacaoEscola());
    }
}
