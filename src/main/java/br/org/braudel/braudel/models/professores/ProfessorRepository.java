package br.org.braudel.braudel.models.professores;

import br.org.braudel.braudel.models.alunos.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professores, Long> {
    Page<Professores> findByAtivoTrue(Pageable pageable);

}
