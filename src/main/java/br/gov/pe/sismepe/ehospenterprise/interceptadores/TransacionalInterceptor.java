package br.gov.pe.sismepe.ehospenterprise.interceptadores;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.gov.pe.sismepe.ehospenterprise.util.MensagemUtil;

@Interceptor @Transacional
public class TransacionalInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject EntityManager manager;
	
	@AroundInvoke
	public Object invoke(InvocationContext context) {
		EntityTransaction trx = manager.getTransaction();
		boolean criador = false;
		Object resultado = null;
		try {
			if (!trx.isActive()) {
				// truque para fazer rollback no que já passou
				// (senão, um futuro commit, confirmaria até mesmo operações sem transação)
				trx.begin();
				trx.rollback();
				// agora sim inicia a transação
				trx.begin();
				criador = true;
			}
			resultado = context.proceed();
		} catch (Exception e) {
			if (trx != null && criador) {
				trx.rollback();
			}
			String causa = e.getCause().toString().toLowerCase();   
			if ( causa.contains("org.hibernate.exception.constraintviolationexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Não foi possível realizar a exclusão, pois este registro já foi utilizado em algum momento!");
			} else if ( causa.contains("org.hibernate.exception.dataexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Implementação de JDBCException indicando que a avaliação da instrução SQL válida contra os dados fornecidos resultou em alguma operação ilegal , tipos incompatíveis ou cardinalidade incorreto.");
			} else if ( causa.contains("org.hibernate.exception.genericjdbcexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Falha genérica não especificada.");
			} else if ( causa.contains("org.hibernate.exception.jdbcconnectionexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Falha de comunicaçõa com o banco de dados, caminho incorreto do banco.");
			} else if ( causa.contains("org.hibernate.exception.lockacquisitionexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Implementação de JDBCException indicando um problema ao adiquirir bloqueio no banco de dados.");
			} else if ( causa.contains("org.hibernate.exception.locktimeoutexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Tempo limite de lock no banco de dado excedido.");
			} else if ( causa.contains("org.hibernate.exception.sqlgrammarexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Implementação de JDBCException indicando que o SQL enviado para o servidor de banco de dados era inválido ( erro de sintaxe, referências a objetos inválidos , etc).");
			} else {
				MensagemUtil.addMensagemDeErro("Erro","Não foi possível realizar a transação!"+e.getCause());
			}
		} finally {
			if (trx != null && trx.isActive() && criador) {
				trx.commit();
			}
		}
		return resultado;
	}
}
