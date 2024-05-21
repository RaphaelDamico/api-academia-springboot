package br.org.serratec.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.academia.entities.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

}
