package com.codegnan.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.codegnan.entity.Employee;

public class Demo_01 {
	public static void main(String[] args) {
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry standardServiceRegistry = standardServiceRegistryBuilder.configure("hibernate.cfg.xml")
				.build();
		MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		Metadata metadata = metadataSources.buildMetadata();
		SessionFactory sessionFactory = metadata.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Employee employee1 = new Employee("rishmitha", "rishmitha@gmail.com", "development");
		Employee employee2 = new Employee("pardhu", "pardhu@gmail.com", "testing");
		Employee employee3 = new Employee("geetha", "geetha@gmail.com", "oracleAdmin");
		Employee employee4 = new Employee("raj", "raj@gmail.com", "Administration");
//		Employee employee  = new Employee("radha", "radha@gmail.com", "SQLAdmin");

		session.getTransaction().begin();
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);
//		Object object=session.save(employee);
//		int id=(Integer)object;
//		System.out.println("saved employee :"+id);

		session.getTransaction().commit();
		session.close();

	}

}
