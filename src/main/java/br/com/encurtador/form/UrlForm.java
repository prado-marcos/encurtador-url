package br.com.encurtador.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import br.com.encurtador.model.Url;

public class UrlForm {
	@NotNull
	@NotEmpty
	@URL
	private String urlOriginal;

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public Url converter() {
		Url url = new Url(urlOriginal);
		return url;
	}
}
