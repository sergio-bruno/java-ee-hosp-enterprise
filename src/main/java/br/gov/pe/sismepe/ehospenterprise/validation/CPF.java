package br.gov.pe.sismepe.ehospenterprise.validation;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.validate.ClientValidator;

@FacesValidator(CPF.VALIDATOR_ID)
public class CPF implements Validator, ClientValidator {

	public static final String VALIDATOR_ID = "validacao.CPF";

	private String cpf;
	private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (value == null) {
			return;
		}

		cpf = ((String) value).replaceAll("\\D", "");

		String[] cpfs = new String[] { "00000000000", "11111111111", "22222222222", 
						               "44444444444", "55555555555", "66666666666",
						               "77777777777", "88888888888", "99999999999" 
									 };
		for (String xcpf : cpfs) {
			if (cpf.equals(xcpf.trim())) {
				throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, value	+ " n�o � um CPF v�lido!", ""));				
			}
		}		
		
		if ( cpf.length() != 11 ) { 
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, value	+ " n�o � um CPF v�lido, o comprimento deve conter 11 digitos", "..."));
		}	

		Integer digito1 = calcularDigito(cpf.substring(0,9), pesoCPF);
	    Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoCPF);
	      
	    if ( ! cpf.equals( cpf.substring(0,9) + digito1.toString() + digito2.toString() ) ) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR, value	+ " n�o � um CPF v�lido, digito verificador n�o confere !", "..."));
	    }
		
	}

	@Override
	public Map<String, Object> getMetadata() {
		return null;
	}

	@Override
	public String getValidatorId() {
		return VALIDATOR_ID;
	}

	private static int calcularDigito(String str, int[] peso) {
	      int soma = 0;
	      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
	         digito = Integer.parseInt(str.substring(indice,indice+1));
	         soma += digito*peso[peso.length-str.length()+indice];
	      }
	      soma = 11 - soma % 11;
	      return soma > 9 ? 0 : soma;
	}	
}