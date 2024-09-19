package br.org.braudel.braudel.models.professores;


import br.org.braudel.braudel.models.alunos.AtualizarAluno;
import br.org.braudel.braudel.models.endereco.Endereco;
import br.org.braudel.braudel.models.enuns.Etinia;
import br.org.braudel.braudel.models.enuns.Sexo;
import com.fasterxml.jackson.databind.annotation.EnumNaming;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Professor")
@Table(name = "professores")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    private String telefone;
    private String email;
    private String disciplina;
    private String escola;
    private String tempoParticipacaoCL;
    private String religiao;
    @Enumerated
    private Etinia etinia;
    @Enumerated
    private Sexo sexo;
    private Boolean imigrante;
    private Boolean deficiente;
    private Boolean ativo;
    @Embedded
    private Endereco endereco;

    public Professores(CadastroProfessoresDTO dados){
        this.ativo = (Boolean) true;
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.telefone = dados.telefone();
        this.disciplina = dados.disciplina();
        this.tempoParticipacaoCL = dados.tempoParticipacaoCL();
        this.email = dados.email();
        this.escola = dados.escola();
        this.etinia = dados.etinia();
        this.sexo = dados.sexo();
        this.imigrante = dados.imigrante();
        this.deficiente = dados.deficiente();
        this.religiao = dados.religiao();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInfromacoes(AtualizarProfessor dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telfone() != null ){
            this.telefone = dados.telfone();
        }
        if(dados.escola()  != null){
            this.escola = dados.escola();
        }
        if(dados.disciplica() != null){
            this.disciplina = dados.disciplica();
        }

        if(dados.enderecoDTO() != null){
            this.endereco.atualizarInformacoes(dados.enderecoDTO());
        }
    }

    public void excluir() {
        this.ativo = (Boolean) false;
    }
}

