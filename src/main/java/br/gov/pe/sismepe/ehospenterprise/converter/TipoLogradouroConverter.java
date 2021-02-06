package br.gov.pe.sismepe.ehospenterprise.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.gov.pe.sismepe.ehospenterprise.dao.TipoLogradouroDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.TipoLogradouro;

@FacesConverter(value="tipoLogradouroConverter")
public class TipoLogradouroConverter implements Converter {

	@Inject
	private TipoLogradouroDao tipoLogradouroDao;
	
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
    	TipoLogradouro retorno = null;
		if (value != null) {
			Long id = new Long(value);
			retorno = tipoLogradouroDao.pesquisarPorId(id);
		}
		return retorno;
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null) {
			TipoLogradouro retorno = (TipoLogradouro) value;
			return retorno.getCdTipoLogradouro() == null ? null : retorno.getCdTipoLogradouro().toString();
		}
		
		return "";        
        
    }
}