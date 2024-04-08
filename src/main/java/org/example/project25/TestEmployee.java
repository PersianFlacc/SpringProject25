package org.example.project25;

import org.example.project25.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class TestEmployee {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            session.remove(employee);

            MutationQuery mutationQuery = session.createMutationQuery("DELETE Employee " +
                    "WHERE name = 'Varvara'");

            int updated = mutationQuery.executeUpdate();


            session.getTransaction().commit();

            System.out.println("Успешно!");

        }
        finally {
            factory.close();
        }
    }
}
