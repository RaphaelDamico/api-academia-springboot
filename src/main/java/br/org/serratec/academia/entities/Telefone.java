package br.org.serratec.academia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "telefone_id")
	private Integer telefoneId;

	@Column(name = "numero")
	private String numero;
	
	@OneToOne
	@JoinColumn(name = "instrutor_id")
	private Instrutor instrutor;

	public Integer getTelefoneId() {
		return telefoneId;
	}

	public void setTelefoneId(Integer telefoneId) {
		this.telefoneId = telefoneId;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

}
