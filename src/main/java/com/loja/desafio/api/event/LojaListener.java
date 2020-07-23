package com.loja.desafio.api.event;

import java.net.URI;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class LojaListener {

	@EventListener
	public void adcionarHeaderLocation(LojaEvent event) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(event.getId()).toUri();
		event.getResponse().setHeader("Location", uri.toASCIIString());
	}
}
