package com.bruno.os.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bruno.os.dtos.ClienteDTO;
import com.bruno.os.dtos.OSDTO;
import com.bruno.os.services.OsService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/os")
public class OsResource {
	
	@Autowired
	private OsService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<OSDTO> findById(@PathVariable Integer id) {
		OSDTO objDTO = new OSDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<OSDTO>> findAll() {

		List<OSDTO> listDTO = service.FindAll().stream().map(obj -> new OSDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}
	
	/*
	 * inserir nova OS
	 */
	@PostMapping
	public ResponseEntity<OSDTO> create(@Valid @RequestBody OSDTO obj) {
		obj = new OSDTO(service.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

	/*
	 * atualizar uma OS
	 */
	@PutMapping
	public ResponseEntity<OSDTO> update(@Valid @RequestBody OSDTO obj) {
		obj = new OSDTO(service.update(obj));

		return ResponseEntity.ok().body(obj);
	}
}
