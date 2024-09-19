package br.org.braudel.braudel.models.alunos;


import br.org.braudel.braudel.models.enuns.Etinia;
import br.org.braudel.braudel.models.enuns.Sexo;
import br.org.braudel.braudel.models.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    private String telefone;
    private String email;
    @Embedded
    private Endereco endereco;
    private String escola;
    private String serieEscola;
    private Boolean multiplicador;
    private String semestreMultiplicador;
    @Enumerated
    private Etinia etinia;
    @Enumerated
    private Sexo sexo;
    private Boolean imigrante;
    private Boolean ativo;
    private Boolean deficiente;
    private String religiao;


    public Aluno(CadastroAlunosDTO dados){
        this.ativo = (Boolean) true;
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.escola = dados.escola();
        this.serieEscola = dados.serieEscola();
        this.multiplicador = dados.multiplicador();
        this.semestreMultiplicador = dados.semestreMultiplicador();
        this.etinia = dados.etinia();
        this.sexo = dados.sexo();
        this.imigrante = dados.imigrante();
        this.deficiente = dados.deficiente();
        this.religiao = dados.religiao();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInfromacoes(AtualizarAluno dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telfone() != null ){
            this.telefone = dados.telfone();
        }
        if(dados.escola()  != null){
            this.escola = dados.escola();
        }
        if(dados.anoEscola() != null){
            this.serieEscola = dados.anoEscola();
        }
        if(dados.multiplicador() != null){
            this.multiplicador = dados.multiplicador();
        }
        if(dados.enderecoDTO() != null){
            this.endereco.atualizarInformacoes(dados.enderecoDTO());
        }
    }

    public void excluir() {
        this.ativo = (Boolean) false;
    }
}
