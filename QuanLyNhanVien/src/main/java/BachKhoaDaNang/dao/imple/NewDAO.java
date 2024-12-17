package BachKhoaDaNang.dao.imple;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import BachKhoaDaNang.Mapper.NewMapper;
import BachKhoaDaNang.bean.News;
import BachKhoaDaNang.dao.INewDAO;
import BachKhoaDaNang.paging.IPageble;

public class NewDAO extends AbstractDAO<News> implements INewDAO {
	
	@Override
	public ArrayList<News> findByCategoryId(String categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(News newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (id,title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?,?, ?, ?, ?, ?, ?, ?)");
		return (long) executeUpdate(sql.toString(),newModel.getId(), newModel.getTitle(), newModel.getContent(), 
				newModel.getThumbnail(), newModel.getShortDescription(), newModel.getCategoryId(),
				newModel.getCreatedDate(), newModel.getCreatedBy());
	}

	@Override
	public News findOne(String id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<News> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(News updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		executeUpdate(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), 
				updateNew.getCreatedBy(), updateNew.getModifiedDate(), 
				updateNew.getModifiedBy(), updateNew.getId());
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM news WHERE id = ?";
		executeUpdate(sql, id);
	}

	@Override
	public ArrayList<News> findAll(IPageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
		}
		return query(sql.toString(), new NewMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM news";
		return count(sql);
	}

	@Override
	public ArrayList<News> findAllbyCatergoryId(String catergoryId, IPageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM news where categoryid =? ");
		if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if (pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" LIMIT "+pageble.getOffset()+", "+pageble.getLimit()+"");
		}
		return query(sql.toString(), new NewMapper(),catergoryId);
	}
}
