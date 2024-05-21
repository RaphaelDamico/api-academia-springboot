package br.org.serratec.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.academia.entities.Instrutor;

public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {

}
