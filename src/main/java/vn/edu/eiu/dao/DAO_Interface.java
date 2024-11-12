package vn.edu.eiu.dao;

import java.util.List;

public interface DAO_Interface<T> {
	
	public List<T> selectAll();
	
	public T selectById(T t);
	
	public boolean insert(T t);
	
	public boolean update (T t);
	
	public boolean delete (T t);
	
	
}