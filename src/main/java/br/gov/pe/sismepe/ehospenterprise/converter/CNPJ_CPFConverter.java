package br.gov.pe.sismepe.ehospenterprise.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("CNPJ_CPFConverter")
public class CNPJ_CPFConverter implements Converter {

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
        	if (valueAsString.length() == 14) {
        		// 10 990 752 0001 09
        		retorno = formatCNPJ(valueAsString.substring(0, 2), valueAsString.substring(2, 5), valueAsString.substring(5, 8), valueAsString.substring(8, 12), valueAsString.substring(12));
        	} else if (valueAsString.length() == 11) {
        		// 866 254 589 74
        		retorno = formatCPF(valueAsString.substring(0, 3), valueAsString.substring(3, 6), valueAsString.substring(6, 9), valueAsString.substring(9));
        	} else {
        		retorno = valueAsString;
        	}
        }
        return retorno;
    }

    private String formatCNPJ(String part1, String part2, String part3, String parte4, String parte5) {
        return part1.concat(".").concat(part2).concat(".").concat(part3).concat("/").concat(parte4).concat("-").concat(parte5);
    }

    private String formatCPF(String part1, String part2, String part3, String parte4) {
        return part1.concat(".").concat(part2).concat(".").concat(part3).concat("-").concat(parte4);
    }
    
    private String join(String[] parts) {
        StringBuilder sb = new StringBuilder();

        for(String part : parts) {
            sb.append(part);
        }

        return sb.toString();
    }
}