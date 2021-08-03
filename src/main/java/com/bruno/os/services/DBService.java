package com.bruno.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.os.domain.Cliente;
import com.bruno.os.domain.OS;
import com.bruno.os.domain.Tecnico;
import com.bruno.os.domain.enuns.Prioridade;
import com.bruno.os.domain.enuns.Status;
import com.bruno.os.repositories.ClienteRepository;
import com.bruno.os.repositories.OSRepository;
import com.bruno.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public void instaciaDB() {
		Tecnico t1 = new Tecnico(null, "Antonio Bruno", "874.032.150-95", "(11) 99393-6883");
		Tecnico t2 = new Tecnico(null, "Antonio Salviano", "592.582.440-79", "(11) 99388-6883");
		Cliente c1 = new Cliente(null, "Betina Campos", "661.893.040-52", "(11) 97777-8888");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
