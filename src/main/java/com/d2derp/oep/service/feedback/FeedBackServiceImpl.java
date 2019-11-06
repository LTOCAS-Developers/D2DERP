package com.d2derp.oep.service.feedback;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.batch.BatchDao;
import com.d2derp.oep.dao.feedback.FeedBackDao;
import com.d2derp.oep.entity.Batch;
import com.d2derp.oep.entity.FeedBack;
import com.d2derp.oep.pojo.FeedBackPojo;

@Transactional
@Service
public class FeedBackServiceImpl implements FeedBackService {

	@Autowired
	private FeedBackDao feedBackDao;
	
	@Autowired
	private BatchDao batchDao;
	
	
	
	@Override
	public void createFeedBack(FeedBackPojo feedBackPojo) {
		
		FeedBack feedBack = new FeedBack();
		Batch batch = null;
		
		if(feedBackPojo.getBatchPojo().getId() == 0) {
			batch = batchDao.getOne(1);
		}
		feedBack.setId(feedBackPojo.getId());
		feedBack.setFeedBack(feedBackPojo.getFeedBack());
		feedBack.setBatch(batch);
		
		feedBackDao.save(feedBack);
	}

}
