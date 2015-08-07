package br.com.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_itens")
public class Item {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ite_codigo")
	private Long codigo;
	
	@Column(name="ite_quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name="ite_valor_parcial", precision = 7, scale = 2, nullable=false)
	private BigDecimal valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tbl_vendas_ven_codigo", referencedColumnName= "ven_codigo", nullable=false)
	private Venda venda;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tbl_produtos_pro_codigo", referencedColumnName= "pro_codigo", nullable=false)
	private Produto produto;
}
