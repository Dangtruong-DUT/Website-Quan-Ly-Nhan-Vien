package BachKhoaDaNang.dao;

import java.util.ArrayList;

import BachKhoaDaNang.bean.User;
import BachKhoaDaNang.paging.IPageble;

public interface IUserDAO extends IGenericDAO<User> {
	ArrayList<User> findAll(IPageble pageble);
	ArrayList<User> findALLEmployeeByIDPB(String idpb,IPageble Pageble);
	User findByEmployeeID(String id);
	int delete(String id);
	int update(User employee);
	int insert(User employee);
	public int getTotalItem() ;
	public int getTotalEmployeeByIDPB(String idpb);
}
