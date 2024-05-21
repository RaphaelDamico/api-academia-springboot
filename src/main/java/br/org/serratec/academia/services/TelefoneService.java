package br.org.serratec.academia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.academia.entities.Telefone;
import br.org.serratec.academia.repositories.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	TelefoneRepository telefoneRepository;

	public List<Telefone> findAll() {
		return telefoneRepository.findAll();
	}

	public Telefone findById(Integer id) {
		return telefoneRepository.findById(id).orElse(null);
	}

	public Telefone save(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}

	public Telefone update(Integer id, Telefone telefone) {
		Telefone entidade = telefoneRepository.getReferenceById(id);
		updateData(entidade, telefone);
		return telefoneRepository.save(entidade);
	}

	private void updateData(Telefone entidade, Telefone telefone) {
		entidade.setNumero(telefone.getNumero());
		entidade.setInstrutor(telefone.getInstrutor());
		
	}

	public Boolean delete(Integer id) {
		if (telefoneRepository.existsById(id)) {
			telefoneRepository.deleteById(id);
			Telefone telefoneDeletado = telefoneRepository.findById(id).orElse(null);
			if (telefoneDeletado == null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public long count() {
		return telefoneRepository.count();
	}
}