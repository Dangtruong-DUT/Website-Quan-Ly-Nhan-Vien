package BachKhoaDaNang.service.imple;

import java.sql.Timestamp;
import java.util.ArrayList;

import javax.inject.Inject;

import BachKhoaDaNang.bean.News;
import BachKhoaDaNang.dao.INewDAO;
import BachKhoaDaNang.paging.IPageble;
import BachKhoaDaNang.service.INewService;


public class NewService implements INewService {
	
	@Inject
	private INewDAO newDao;


	@Override
	public ArrayList<News> findByCategoryId(String categoryId) {
		return newDao.findByCategoryId(categoryId);
	}

	@Override
	public News save(News newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newDao.save(newModel);
		return null;
	}

	@Override
	public News update(News updateNew) {
		News oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}

	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
		    newDao.delete(id);
		}
	}

	@Override
	public ArrayList<News> findAll(IPageble pageble) {
		return newDao.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		return newDao.getTotalItem();
	}

    @Override
    public News findOne(String id) {
		News newModel = newDao.findOne(id);
        return newModel;
    }

	@Override
	public ArrayList<News> findAllbyCategoryId(String catergoryId, IPageble pageble) {
		return newDao.findAllbyCatergoryId(catergoryId, pageble);
	}

}
