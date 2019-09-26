package com.d2derp.oep.pojo;

import org.springframework.stereotype.Component;

import com.d2derp.oep.entity.Client;

@Component
public class BatchPojo {

	private int id;
	private String name;
	private ClientPojo clientPojo;



	public ClientPojo getClientPojo() {
		return clientPojo;
	}

	public void setClientPojo(ClientPojo clientPojo) {
		this.clientPojo = clientPojo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
