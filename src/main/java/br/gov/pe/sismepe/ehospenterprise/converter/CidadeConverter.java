package br.gov.pe.sismepe.ehospenterprise.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.gov.pe.sismepe.ehospenterprise.dao.CidadeDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Cidade;

@FacesConverter(value="cidadeConverter")
public class CidadeConverter implements Converter {

	@Inject
	private CidadeDao cidadeDao;
	
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
    	Cidade retorno = null;
		if (value != null) {
			Long id = new Long(value);
			retorno = cidadeDao.pesquisarPorId(id);
		}
		return retorno;
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null) {
			Cidade retorno = (Cidade) value;
			return retorno.getCdCidade() == null ? null : retorno.getCdCidade().toString();
		}
		
		return "";        
        
    }
}