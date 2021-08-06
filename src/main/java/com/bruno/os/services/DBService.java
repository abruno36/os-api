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
		Tecnico t3 = new Tecnico(null, "Antonio Santos Mendes", "476.626.620-04", "(11) 99388-5555");
		Tecnico t4 = new Tecnico(null, "Marcos Silva", "937.421.940-97", "(11) 99388-6666");
		Tecnico t5 = new Tecnico(null, "Salvador Mendes", "048.951.560-60", "(11) 99388-3333");
		Cliente c1 = new Cliente(null, "Betina Campos", "661.893.040-52", "(11) 97777-5555");
		Cliente c2 = new Cliente(null, "Samuel Paes", "671.696.480-08", "(11) 97777-3333");
		Cliente c3 = new Cliente(null, "Bernardo Elisios", "671.696.480-08", "(11) 97777-9999");
		OS os1 = new OS(null, Prioridade.ALTA, "OS 01", Status.ANDAMENTO, t1, c1);
		OS os2 = new OS(null, Prioridade.MEDIA, "OS 02", Status.ANDAMENTO, t3, c2);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
		osRepository.saveAll(Arrays.asList(os1, os2));
	}

}
