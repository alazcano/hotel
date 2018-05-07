package test;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import beans.*;
public class EmpleadoJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAHR3");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Employee e1, e2, e3;
		Department d1;
		Job j1;
		tx.begin();
		e1=em.find(Employee.class, Long.valueOf(103));
		d1= new Department(Long.valueOf(300), "Inteligencia Artificial", BigDecimal.valueOf(1400), e1);
		j1= new Job("AI_PROG", "Programador AI", BigDecimal.valueOf(120000), BigDecimal.valueOf(30000));
		//em.persist(d1);
		//em.persist(j1);
		e2=new Employee(Long.valueOf(166), BigDecimal.valueOf(1), "falsa@fake.com", "Eva", "Fina", "91000", BigDecimal.valueOf(6600), d1, e1, j1);
		em.persist(e2);
		tx.commit();
		/*
		System.out.println("Este no soy yo: "+e1.getLastName()+ " "+e1.getFirstName());
		System.out.println("El jefe es: "+e1.getCoordinador().getLastName()+ " "+e1.getCoordinador().getFirstName());
		System.out.println("Mi jefe de departamento es: "+e1.getDepartmentID().getManagerID().getLastName());
		List<Employee> listae = e1.getMinions();
		System.out.println("Lista de los trabajadores");
		for (Employee elem : listae) {
			System.out.println(elem.getLastName());
		}
		*/
		/*
		String sql="select e from Employee e where e.employeeId=114";
		//String sql="select e from Employee e where e.employeeId=?1";
		Query q1= em.createQuery(sql, Employee.class);
		//q1.setParameter(1, Long.valueOf(114));
		e2= (Employee)q1.getSingleResult();
		System.out.println(e2.getLastName());
		*/
	}

}
