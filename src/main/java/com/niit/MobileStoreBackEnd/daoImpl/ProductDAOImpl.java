package com.niit.MobileStoreBackEnd.daoImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.niit.MobileStoreBackEnd.dao.ProductDAO;
import com.niit.MobileStoreBackEnd.domain.Product;

@Repository("productDAO")     //to create singleton instance
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	@Autowired private SessionFactory sessionFactory;	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
		
	private Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public List<Product> list()
	{
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}
		
	public boolean save(Product product)
	{
		try
		{
			getCurrentSession().save(product);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Product product) 
	{
		try
		{
			getCurrentSession().update(product);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String id) 	
	{
		try
		{
			getCurrentSession().delete(getProductById(id));
		} 
		catch (Exception e)
		{						
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Product getProductById(String id)
	{
		return (Product) getCurrentSession().get(Product.class,id);
	}
		
	public Product getProductByName(String name) 
	{
		return (Product) getCurrentSession().createQuery("from Product where name=?").setString(0,name).uniqueResult();
	}
	
	@SuppressWarnings("deprecation")
	public void storeFile(Product p,HttpServletRequest request)
		{
			System.out.println(request.getRealPath("/"));
			String path=request.getRealPath("/")+"resources\\Images\\ProductImages\\"+p.getImagepath();
			MultipartFile file=p.getFile();
			if(!file.isEmpty())
			{
				try
				{
					byte[] bytes=file.getBytes();
					System.out.println(file.getOriginalFilename());
					File serverFile=new File(path);
					serverFile.createNewFile();
					BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
	
	@Override
	public List<Product> search(String productName) {
		String hql = "from Product where name like '%"+productName+"%'";
		Query query = sessionFactory.openSession().createQuery(hql);
		return query.list();
		
	}
}