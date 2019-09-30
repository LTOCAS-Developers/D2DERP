package com.d2derp.oep.service.client;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.d2derp.oep.dao.client.ClientDao;
import com.d2derp.oep.dao.user.UserDao;
import com.d2derp.oep.entity.Client;
import com.d2derp.oep.pojo.ClientPojo;


@Transactional
@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	ClientDao clientDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ClientDao getClientRepo() {
		return clientDao;
	}

	public void setClientRepo(ClientDao clientRepo) {
		this.clientDao = clientRepo;
	}

	@Override
	public List<ClientPojo> listClient() {
		List<ClientPojo> clientPojoList=new ArrayList();
		List<Client> clientList=clientDao.findAll();
		for(int i=0;i<clientList.size();i++)
		{
			
			Client client=clientList.get(i);
			
			ClientPojo clientPojo = new ClientPojo();
			clientPojo.setCompanyName(client.getCompanyName());
			clientPojo.setId(client.getId());

			clientPojoList.add(clientPojo);
			
		}
		
		
		
		return clientPojoList;
	}

	public ClientPojo findClient(int id) {
		
		Optional<Client> client=clientDao.findById(id);
		ClientPojo clientPojo=new ClientPojo();
		clientPojo.setCompanyName(client.get().getCompanyName());
		clientPojo.setId(client.get().getId());
	
		
		return clientPojo;
	}

	@Override
	public void deleteClient(int id) {

		clientDao.deleteById(id);

	}
	
	public ClientPojo editClient( ClientPojo clientPojo) {
		
		Optional<Client> client=clientDao.findById(clientPojo.getId());
		System.out.println(clientPojo.getId());
		client.get().setCompanyName(clientPojo.getCompanyName());
		client.get().setId(clientPojo.getId());
		
		return clientPojo;
	}

	@Override
	public List<ClientPojo> searchClient(String searchTerm) {
		List<ClientPojo> clientPojoList=new ArrayList();
		List<Client> clientList=clientDao.findBySearchTerm(searchTerm);
		for(int i=0;i<clientList.size();i++)
		{
			
			Client client=clientList.get(i);
			
			ClientPojo clientPojo = new ClientPojo();
			clientPojo.setCompanyName(client.getCompanyName());
			clientPojo.setId(client.getId());

			clientPojoList.add(clientPojo);
			
		}
	
		return clientPojoList;
	}
	
	



	
}
