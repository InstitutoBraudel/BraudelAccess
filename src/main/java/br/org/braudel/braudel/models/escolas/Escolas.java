package br.org.braudel.braudel.models.escolas;


import br.org.braudel.braudel.models.alunos.AtualizarAluno;
import br.org.braudel.braudel.models.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Escola")
@Table(name = "escolas")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Escolas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeInstituticao;
    private String nomeCoordPedago;
    private String emailCoordPedago;
    private String telefoneCoordPedago;
    private String telefoneEscola;
    private String email;
    private String anoAdesaoCL;
    private String alunosParticipantesCL;
    private String professoresParticipantesCL;
    private String vinculacaoEscola;
    private String turmasParticipantesCL;
    private Boolean autorizaContato;
    private Boolean ativo;
    private Endereco endereco;

    public Escolas(CadastroEscolasDTO dados){
        this.ativo = (Boolean) true;
        this.autorizaContato = (Boolean) true;
        this.nomeInstituticao = dados.nomeInstituicao();
        this.nomeCoordPedago = dados.nomeCoordPedago();
        this.alunosParticipantesCL = dados.alunosParticipantesCL();
        this.telefoneEscola = dados.telefoneEscola();
        this.telefoneCoordPedago = dados.telefoneCoordPedago();
        this.email = dados.email();
        this.emailCoordPedago = dados.emailCoordPedago();
        this.anoAdesaoCL = dados.anoAdesaoCL();
        this.professoresParticipantesCL = dados.professoresParticipantesCL();
        this.vinculacaoEscola = dados.vinvulacaoEscola();
        this.turmasParticipantesCL = dados.turmasParticipantesCL();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInfromacoes(AtualizarEscola dados) {
        if(dados.nomeInstituticao() != null){
            this.nomeInstituticao = dados.nomeInstituticao();
        }
        if(dados.telefoneEscola() != null ){
            this.telefoneEscola = dados.telefoneEscola();
        }
        if(dados.nomeCoordPedago() != null ){
            this.nomeCoordPedago = dados.nomeCoordPedago();
        }
        if(dados.telefoneCoordPedago()  != null){
            this.telefoneCoordPedago = dados.telefoneCoordPedago();
        }
        if(dados.emailCoordPedago()  != null){
            this.emailCoordPedago = dados.emailCoordPedago();
        }
        if(dados.enderecoDTO() != null){
            this.endereco.atualizarInformacoes(dados.enderecoDTO());
        }
    }

    public void excluir() {
        this.ativo = (Boolean) false;
    }
}
