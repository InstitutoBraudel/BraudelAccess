package br.org.braudel.braudel.models.alunos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.channels.FileChannel;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Page<Aluno> findByAtivoTrue(Pageable pageable);
}
