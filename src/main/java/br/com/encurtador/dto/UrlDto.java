package br.com.encurtador.dto;

import br.com.encurtador.model.Url;

public class UrlDto {
	private Long id;
	private String urlId;
	private String urlOriginal;

	public UrlDto(Url url) {
		this.id = url.getId();
		this.urlId = url.getUrlId();
		this.urlOriginal = url.getUrlOriginal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public void setUrlOriginal(String urlOriginal) {
		this.urlOriginal = urlOriginal;
	}

	public String getUrlId() {
		return urlId;
	}

	public void setUrlId(String urlId) {
		this.urlId = urlId;
	}
}
