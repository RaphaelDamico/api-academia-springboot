package br.org.serratec.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.academia.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
