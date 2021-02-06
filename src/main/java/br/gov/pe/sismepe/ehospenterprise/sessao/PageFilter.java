/**
 * Classe PageFilter.java
 * Classe usada para capturar todo e qualquer acesso do usuário e manter a página anterior e
 * atual que está sendo acessada, assim podemos garantir que ele possa voltar à página
 * anterior sempre que precisar.
 * 
 * @author SERGIO LEITE BRUNO
 * @version 0.00.1
 */

package br.gov.pe.sismepe.ehospenterprise.sessao;

import java.io.IOException;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
public class PageFilter implements Filter {
 
    public void destroy() {
    }
 
    public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain) throws IOException, ServletException {
 
       HttpSession sess = ((HttpServletRequest) request).getSession(true);
 
       String newCurrentPage = ((HttpServletRequest) request).getServletPath();
 
       if (sess.getAttribute("currentPage") == null) {
           sess.setAttribute("lastPage", newCurrentPage);
           sess.setAttribute("currentPage", newCurrentPage);
       } else {
 
           String oldCurrentPage = sess.getAttribute("currentPage").toString();
           if (!oldCurrentPage.equals(newCurrentPage)) {
             sess.setAttribute("lastPage", oldCurrentPage);
             sess.setAttribute("currentPage", newCurrentPage);
           }
       }
 
       chain.doFilter(request, response);
 
    }
 
    public void init(FilterConfig arg0) throws ServletException {
    }
 
}