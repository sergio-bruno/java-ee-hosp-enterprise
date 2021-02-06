package br.gov.pe.sismepe.ehospenterprise.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.gov.pe.sismepe.ehospenterprise.dao.UfDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Uf;

@FacesConverter(value="ufConverter")
public class UfConverter implements Converter {

	@Inject
	private UfDao ufDao;
	
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
    	Uf retorno = null;
		if (value != null) {
			retorno = ufDao.pesquisarPorId(value);
		}
		return retorno;
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null) {
			Uf retorno = (Uf) value;
			return retorno.getCdUf() == null ? null : retorno.getCdUf().toString();
		}
		
		return "";        
        
    }
}