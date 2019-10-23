package com.d2derp.oep.service.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.batch.BatchDao;
import com.d2derp.oep.dao.client.ClientDao;
import com.d2derp.oep.entity.Batch;
import com.d2derp.oep.entity.Client;
import com.d2derp.oep.pojo.BatchPojo;
import com.d2derp.oep.pojo.ClientPojo;

@Transactional
@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchDao batchDao;

	@Autowired
	private ClientDao clientDao;

	public BatchDao getBatchDao() {
		return batchDao;
	}

	public void setBatchDao(BatchDao batchDao) {
		this.batchDao = batchDao;
	}

	@Override
	public void saveBatch(BatchPojo batchPojo) {
		Batch batch = new Batch();
		Client client = null;
		System.out.println(batchPojo.getName());
		if (batchPojo.getClientPojo().getId() == 0) {

			client = clientDao.getOne(1);
		}
		batch.setName(batchPojo.getName());
		batch.setClient(client);
		System.out.println(batch.getClient().getCompanyName());

		batchDao.save(batch);

	}

	@Override
	public List<BatchPojo> listBatch() {
		List<BatchPojo> batchPojoList = new ArrayList();
		List<Batch> batchList = batchDao.findAll();
		ClientPojo clientPojo = new ClientPojo();

		for (int i = 0; i < batchList.size(); i++) {

			Batch batch = batchList.get(i);

			BatchPojo batchPojo = new BatchPojo();
			batchPojo.setName(batch.getName());
			batchPojo.setId(batch.getId());
			clientPojo.setCompanyName(batch.getClient().getCompanyName());
			clientPojo.setId(batch.getClient().getId());
			batchPojo.setClientPojo(clientPojo);
			batchPojoList.add(batchPojo);

		}

		return batchPojoList;
	}

	@Override
	public BatchPojo findBatch(int id) {
		ClientPojo clientPojo = new ClientPojo();

		Optional<Batch> batch = batchDao.findById(id);
		BatchPojo batchPojo = new BatchPojo();
		batchPojo.setName(batch.get().getName());
		batchPojo.setId(batch.get().getId());
		clientPojo.setCompanyName(batch.get().getClient().getCompanyName());
		clientPojo.setId(batch.get().getClient().getId());
		batchPojo.setClientPojo(clientPojo);

		return batchPojo;
	}

	@Override
	public void deleteBatch(int id) {

		batchDao.deleteById(id);

	}

	@Override
	public BatchPojo editBatch(BatchPojo batchPojo) {

		Optional<Batch> batch = batchDao.findById(batchPojo.getId());
		System.out.println(batchPojo.getId());
		batch.get().setName(batchPojo.getName());
		batch.get().setId(batchPojo.getId());

		return batchPojo;
	}

}