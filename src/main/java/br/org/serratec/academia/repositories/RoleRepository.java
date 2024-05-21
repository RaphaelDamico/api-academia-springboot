package br.org.serratec.academia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.academia.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
