package br.com.isidrocorp.eventdash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.eventdash.dao.UsuarioDAO;
import br.com.isidrocorp.eventdash.model.Usuario;

@CrossOrigin("*")
@RestController
public class UsuarioController {

	@Autowired // o Autowired indica a INJECAO DE DEPENDÊNCIAS
	private UsuarioDAO dao;
	
//	@GetMapping("/usuarios")
//	public ArrayList<Usuario> recuperarTodos(){
//		ArrayList<Usuario> lista;
//		lista = (ArrayList<Usuario>)dao.findAll();
//		return lista;
//	}
	@PostMapping("/login")
	public ResponseEntity<Usuario> fazerLogin(@RequestBody Usuario dados){
		Usuario resultado = dao.findByEmailOrRacf(dados.getEmail(), dados.getRacf());
		
		if (resultado != null) { //se o usuario existe no banco
			if (resultado.getSenha().equals(dados.getSenha())){ // as senhas batem
				resultado.setSenha("**********");
				return ResponseEntity.ok(resultado);
			}
			return ResponseEntity.status(401).build();
		}
		//retorna 404 - pois não existe esse email ou racf no banco
		return ResponseEntity.notFound().build();
	}
	
}
