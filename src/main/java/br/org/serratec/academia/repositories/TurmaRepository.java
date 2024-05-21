package br.org.serratec.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.academia.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
