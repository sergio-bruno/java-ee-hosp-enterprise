package br.gov.pe.sismepe.ehospenterprise.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("CEPConverter")
public class CEPConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String[] parts = value.split("-\\.");
        return Integer.parseInt(join(parts));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String valueAsString = value.toString();
        String retorno = "";
        if ( valueAsString == null || valueAsString.equals("")){
        	retorno = "";
        } else {
        	retorno = formatCEP(valueAsString.substring(0, 2), valueAsString.substring(2, 5), valueAsString.substring(5));
        }
        return retorno;
    }

    private String formatCEP(String part1, String part2, String part3) {
        return part1.concat(".").concat(part2).concat("-").concat(part3);
    }

    private String join(String[] parts) {
        StringBuilder sb = new StringBuilder();

        for(String part : parts) {
            sb.append(part);
        }

        return sb.toString();
    }
}