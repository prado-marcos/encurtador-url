package br.com.encurtador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.encurtador.model.Url;

public interface UrlRepository extends JpaRepository<Url, String> {

	Url findByUrlId(String urlId);

	void deleteByUrlId(String urlId);
}
