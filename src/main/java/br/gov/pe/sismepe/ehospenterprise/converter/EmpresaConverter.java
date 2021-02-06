package br.gov.pe.sismepe.ehospenterprise.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.gov.pe.sismepe.ehospenterprise.dao.EmpresaDao;
import br.gov.pe.sismepe.ehospenterprise.entidades.Empresa;

@FacesConverter(value="empresaConverter")
public class EmpresaConverter implements Converter {

	@Inject
	private EmpresaDao empresaDao;
	
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
    	Empresa retorno = null;
		if (value != null) {
			Long id = new Long(value);
			retorno = empresaDao.pesquisarPorId(id);
		}
		return retorno;
    }
 
    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null) {
			Empresa retorno = (Empresa) value;
			return retorno.getCdEmpresa() == null ? null : retorno.getCdEmpresa().toString();
		}
		
		return "";        
        
    }
}