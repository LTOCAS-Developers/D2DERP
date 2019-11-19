package com.d2derp.oep.service.feedback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.batch.BatchDao;
import com.d2derp.oep.dao.feedback.FeedBackDao;
import com.d2derp.oep.entity.Batch;
import com.d2derp.oep.entity.FeedBack;
import com.d2derp.oep.pojo.BatchPojo;
import com.d2derp.oep.pojo.FeedBackPojo;

@Transactional
@Service
public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	private FeedBackDao feedBackDao;
	
	@Autowired
	private BatchDao batchDao;
		
	
	@Override
	public void save(FeedBackPojo feedBackPojo) {
		
		FeedBack feedBack = new FeedBack();
		Batch batch = null;
		

		batch = batchDao.getOne(feedBackPojo.getBatchPojo().getId());
		
		feedBack.setFeedBack(feedBackPojo.getFeedBack());
		feedBack.setBatch(batch);
		
		feedBackDao.save(feedBack);
	}



	@Override
	public List<FeedBackPojo> listFeedBack() {
		List<FeedBackPojo> feedBackPojoList = new ArrayList<>();
		List<FeedBack> feedBackList =  feedBackDao.findAll();
		
		BatchPojo batchPojo = new BatchPojo();
		
		for(int i=0;i<feedBackList.size();i++) {
			
			FeedBack feedBack = feedBackList.get(i);
			
			FeedBackPojo feedBackPojo = new FeedBackPojo();
			feedBackPojo.setId(feedBack.getId());
			feedBackPojo.setFeedBack(feedBack.getFeedBack());
			batchPojo.setId(feedBack.getBatch().getId());
			
			
			feedBackPojo.setBatchPojo(batchPojo);
			feedBackPojoList.add(feedBackPojo);

			
		}

		return feedBackPojoList;
	}



	@Override
	public FeedBackPojo listById(int id) {
		BatchPojo batchPojo = new BatchPojo();
		
		Optional<FeedBack> feedBack = feedBackDao.findById(id);
		FeedBackPojo feedBackPojo = new FeedBackPojo();
		feedBackPojo.setId(feedBack.get().getId());
		feedBackPojo.setFeedBack(feedBack.get().getFeedBack());
		feedBackPojo.setBatchPojo(batchPojo);
		
		
		return feedBackPojo;
	}



	@Override
	public FeedBackPojo editFeedBack(FeedBackPojo feedBackPojo) {
		
		Optional<FeedBack> feedBack = feedBackDao.findById(feedBackPojo.getId());
		feedBack.get().setId(feedBackPojo.getId());
		feedBack.get().setFeedBack(feedBackPojo.getFeedBack());
		feedBack.get().getBatch().setId(feedBackPojo.getBatchPojo().getId());
		
		return feedBackPojo;
	}



	@Override
	public void deleteFeedBack(int id) {
		 feedBackDao.deleteById(id); 	
	}
	
	

}
