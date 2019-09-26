package com.d2derp.oep.service.client;

import java.util.List;
import java.util.Optional;

import com.d2derp.oep.entity.Client;
import com.d2derp.oep.entity.User;
import com.d2derp.oep.pojo.ClientPojo;

public interface ClientService {

	List<ClientPojo> listClient();

	ClientPojo findClient(int id);

	void deleteClient(int id);

	ClientPojo editClient(ClientPojo clientPojo);
}
