package br.org.braudel.braudel.models.escolas;

import br.org.braudel.braudel.models.endereco.CadastroEnderecoDTO;

public record AtualizarEscola(
        Long id,
        String nomeInstituticao,
        String telefoneEscola,
        String nomeCoordPedago,
        String telefoneCoordPedago,
        String emailCoordPedago,
        CadastroEnderecoDTO enderecoDTO
) {
}
