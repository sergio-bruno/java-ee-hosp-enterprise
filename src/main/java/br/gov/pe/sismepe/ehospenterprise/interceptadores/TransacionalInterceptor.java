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
				// truque para fazer rollback no que j� passou
				// (sen�o, um futuro commit, confirmaria at� mesmo opera��es sem transa��o)
				trx.begin();
				trx.rollback();
				// agora sim inicia a transa��o
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
				MensagemUtil.addMensagemDeErro("Erro","N�o foi poss�vel realizar a exclus�o, pois este registro j� foi utilizado em algum momento!");
			} else if ( causa.contains("org.hibernate.exception.dataexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Implementa��o de JDBCException indicando que a avalia��o da instru��o SQL v�lida contra os dados fornecidos resultou em alguma opera��o ilegal , tipos incompat�veis ou cardinalidade incorreto.");
			} else if ( causa.contains("org.hibernate.exception.genericjdbcexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Falha gen�rica n�o especificada.");
			} else if ( causa.contains("org.hibernate.exception.jdbcconnectionexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Falha de comunica��a com o banco de dados, caminho incorreto do banco.");
			} else if ( causa.contains("org.hibernate.exception.lockacquisitionexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Implementa��o de JDBCException indicando um problema ao adiquirir bloqueio no banco de dados.");
			} else if ( causa.contains("org.hibernate.exception.locktimeoutexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Tempo limite de lock no banco de dado excedido.");
			} else if ( causa.contains("org.hibernate.exception.sqlgrammarexception") ) {  
				MensagemUtil.addMensagemDeErro("Erro","Implementa��o de JDBCException indicando que o SQL enviado para o servidor de banco de dados era inv�lido ( erro de sintaxe, refer�ncias a objetos inv�lidos , etc).");
			} else {
				MensagemUtil.addMensagemDeErro("Erro","N�o foi poss�vel realizar a transa��o!"+e.getCause());
			}
		} finally {
			if (trx != null && trx.isActive() && criador) {
				trx.commit();
			}
		}
		return resultado;
	}
}
