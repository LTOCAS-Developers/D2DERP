package com.d2derp.oep.controller.client;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.entity.Client;
import com.d2derp.oep.entity.User;
import com.d2derp.oep.pojo.ClientPojo;
import com.d2derp.oep.service.client.ClientService;
import com.d2derp.oep.service.user.UserService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}



	@GetMapping(value = "/clientList")
	public ResponseEntity<List<ClientPojo>> listUser() {
		return ResponseEntity.ok(clientService.listClient());
	}


	@GetMapping(value = "/getClient/{id}")
	public ResponseEntity<ClientPojo> getClient(@PathVariable(value = "id") int id) {
		return ResponseEntity.ok(clientService.findClient(id)); 

	}
	
	@PutMapping(value = "/editClient")
	public ResponseEntity<ClientPojo> updateClient(@RequestBody ClientPojo clientPojo) {

		if (clientService.findClient(clientPojo.getId())!= null) {
            ResponseEntity.badRequest().build();
        }
	        return ResponseEntity.ok(clientService.editClient(clientPojo));
	}

	@DeleteMapping(value = "/deleteClient/{id}")
	public ResponseEntity  deleteClient(@PathVariable(value ="id") int id) {
        if (clientService.findClient(id) !=null) {
            ResponseEntity.badRequest().build();
        }

        clientService.deleteClient(id);

        return ResponseEntity.ok().build();
 
	}

}