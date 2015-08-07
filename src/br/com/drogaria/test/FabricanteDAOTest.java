package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	
	@Test
	public void salvar(){
		Fabricante f1 = new Fabricante();
		Fabricante f2 = new Fabricante();
		f1.setDescricao("Descricao C");
		f2.setDescricao("Descricao D");
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1);
		dao.salvar(f2);
	}
	
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		for(Fabricante fab : fabricantes ){
			System.out.println(fab);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(1L);
		Fabricante f2 = dao.buscarPorCodigo(2L);
		System.out.println(f1);
		System.out.println(f2);
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(1L);
		dao.excluir(f1);
	}
	
	@Test
	@Ignore
	public void editar(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(1L);
		f1.setDescricao("DESCRICAO TESTE");
		dao.editar(f1);
	}
	
}
