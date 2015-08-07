package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.HibernateUtil;

public class ProdutoDAO {

	public void salvar(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = sessao.beginTransaction();
			sessao.save(produto);
			transaction.commit();
		}catch(RuntimeException ex){
			if(transaction != null){
				transaction.rollback();	
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar(){
		Session sessao  = HibernateUtil.getSessionFactory().openSession();
		List<Produto> produtos = null;
		try{
			Query consulta = sessao.getNamedQuery("Produto.listar");
			produtos = consulta.list();
		}catch(RuntimeException e){
			throw e;
		}finally{
			sessao.close();
		}
		return produtos;
	}
	
	public Produto buscarPorCodigo(Long codigo){
		Session sessao  = HibernateUtil.getSessionFactory().openSession();
		Produto produto = null;
		try{
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			produto =  (Produto) consulta.uniqueResult();
		}catch(RuntimeException e){
			throw e;
		}finally{
			sessao.close();
		}
		return produto;
	}
	
	public void excluir(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
			transacao.commit();
		}catch(RuntimeException e){
			if(transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
	
	public void editar(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.update(produto);
			transacao.commit();
		}catch(RuntimeException e){
			if(transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
}
