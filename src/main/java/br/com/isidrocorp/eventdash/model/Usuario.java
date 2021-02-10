package br.com.isidrocorp.eventdash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/* O objetivo desta classe é mapear a propria estrutura da classe Usuario
 * à estrutura da tabela itmn_usuario
 * 
 * Quais são os requisitos?
 * 
 * 
 * 
 */

@Entity  
@Table(name="itmn_usuario") // especifico o nome da tabela
public class Usuario {
	
	@Column(name="id_usuario")		// vou maperar o atributo para o nome da coluna
	@Id								// indico a chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) // preciso informar que é autoincrement
	private int id;
	
	@Column(name="nome_usuario", length = 100, nullable = false)
	private String nome;
	
	@Column(name="email_usuario", length = 100, nullable = false)
	private String email;
	
	@Column(name="racf_usuario", length = 7, nullable = false)
	private String racf;
	
	@Column(name="senha_usuario", length = 50, nullable = false)
	private String senha;
	
	@Column(name="ramal_usuario", length = 10)
	private String ramal;
	
	@Column(name="link_foto", length = 255)
	private String linkfoto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getLinkfoto() {
		return linkfoto;
	}
	public void setLinkfoto(String linkfoto) {
		this.linkfoto = linkfoto;
	}
	
}
