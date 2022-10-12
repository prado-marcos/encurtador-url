package br.com.encurtador.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.encurtador.dto.UrlDto;
import br.com.encurtador.form.UrlForm;
import br.com.encurtador.model.Url;
import br.com.encurtador.repository.UrlRepository;

@RestController
@RequestMapping("/")
public class UrlController {
	@Autowired
	private UrlRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<UrlDto> cadastrar(@RequestBody @Valid UrlForm form, UriComponentsBuilder builder) {
		Url url = form.converter();
		repository.save(url);
		URI uri = builder.path("/{urlId}").buildAndExpand(url.getId()).toUri();
		return ResponseEntity.created(uri).body(new UrlDto(url));
	}

	@GetMapping("/{urlId}")
	public ResponseEntity<UrlDto> redirecionar(@PathVariable String urlId) {
		Url url = repository.findByUrlId(urlId);
		if (url != null) {
			return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url.getUrlOriginal())).build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{urlId}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable String urlId) {
		Url url = repository.findByUrlId(urlId);
		if (url != null) {
			repository.deleteByUrlId(urlId);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
