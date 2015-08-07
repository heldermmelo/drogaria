package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Item;
import br.com.drogaria.util.HibernateUtil;

public class ItemDAO {

	public void inserir(Item item){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try{
			transaction = sessao.beginTransaction();
			sessao.save(item);
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
	public List<Item> listar(){
		Session sessao  = HibernateUtil.getSessionFactory().openSession();
		List<Item> items = null;
		try{
			Query consulta = sessao.getNamedQuery("Item.listar");
			items = consulta.list();
		}catch(RuntimeException e){
			throw e;
		}finally{
			sessao.close();
		}
		return items;
	}
	
	public Item buscarPorCodigo(Long codigo){
		Session sessao  = HibernateUtil.getSessionFactory().openSession();
		Item item = null;
		try{
			Query consulta = sessao.getNamedQuery("Item.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			item =  (Item) consulta.uniqueResult();
		}catch(RuntimeException e){
			throw e;
		}finally{
			sessao.close();
		}
		return item;
	}
	
	public void excluir(Item item){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(item);
			transacao.commit();
		}catch(RuntimeException e){
			if(transacao != null){
				transacao.rollback();
			}
		}finally{
			sessao.close();
		}
	}
	
	public void editar(Item item){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try{
			transacao = sessao.beginTransaction();
			sessao.update(item);
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
