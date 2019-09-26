package com.d2derp.oep.controller.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.dao.batch.BatchDao;
import com.d2derp.oep.pojo.BatchPojo;
import com.d2derp.oep.service.batch.BatchService;

@RestController
@RequestMapping("/batch")

public class BatchController {

	@Autowired
	private BatchService batchService;

	public BatchService getBatchService() {
		return batchService;
	}

	public void setBatchService(BatchService batchService) {
		this.batchService = batchService;
	}
	
	@PostMapping(value="/save")
	public void saveBatch(@RequestBody BatchPojo batchPojo){
		batchService.saveBatch(batchPojo); 
		
	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<BatchPojo>> listBatch() {
		System.out.println("im worked");
		return ResponseEntity.ok(batchService.listBatch());
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<BatchPojo> getBatch(@PathVariable(value = "id") int id) {
		return ResponseEntity.ok(batchService.findBatch(id));

	}

	@PutMapping(value = "/edit")
	public ResponseEntity<BatchPojo> updateBatch(@RequestBody BatchPojo batchPojo) {

		if (batchService.findBatch(batchPojo.getId()) != null) {
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(batchService.editBatch(batchPojo));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity deleteBatch(@PathVariable(value = "id") int id) {
		if (batchService.findBatch(id) != null) {
			ResponseEntity.badRequest().build();
		}

		batchService.deleteBatch(id);

		return ResponseEntity.ok().build();

	}

}
