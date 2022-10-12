package br.com.encurtador.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String urlId = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
	private String urlOriginal;

	public Url() {
	}

	public Url(String urlOriginal) {
		this.urlOriginal = urlOriginal;

	}

	public Long getId() {
		return id;
	}

	public String getUrlOriginal() {
		return urlOriginal;
	}

	public String getUrlId() {
		return urlId;
	}

}
