package com.niit.MobileStoreBackEnd.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import com.niit.MobileStoreBackEnd.dao.UserDAO;
import com.niit.MobileStoreBackEnd.domain.User;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContextConfig con=new ApplicationContextConfig();

        DataSource ds=con.getH2DataSource();
        System.out.println(ds);
        SessionFactory sf=con.getSessionFactory(ds);
        System.out.println( "Hello World!" );
        User u=new User();
        UserDAO us=con.getUserDAO(sf);
        System.out.println("main method ends...");
    }
}
