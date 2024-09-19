package br.org.braudel.braudel.models.escolas;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escolas, Long> {
    Page<Escolas> findByAtivoTrue(Pageable pageable);
}
