package beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DEPARTMENTS database table.
 * 
 */
@Entity
@Table(name="DEPARTMENTS")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DEPARTMENTS_DEPARTMENTID_GENERATOR", sequenceName="DEPARTMENTS_SEQ", allocationSize=10)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTMENTS_DEPARTMENTID_GENERATOR")
	@Column(name="DEPARTMENT_ID")
	private long departmentId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (departmentId ^ (departmentId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentId != other.departmentId)
			return false;
		return true;
	}

	@Column(name="DEPARTMENT_NAME")
	private String departmentName;

	@Column(name="LOCATION_ID")
	private java.math.BigDecimal locationId;

	//uni-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private Employee managerID;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="departmentID")
	private List<Employee> employees;

	public Department() {
	}
	
	

	public Department(long departmentId, String departmentName, BigDecimal locationId, Employee managerID) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.locationId = locationId;
		this.managerID = managerID;
		
	}

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public java.math.BigDecimal getLocationId() {
		return this.locationId;
	}

	public void setLocationId(java.math.BigDecimal locationId) {
		this.locationId = locationId;
	}

	public Employee getManagerID() {
		return this.managerID;
	}

	public void setManagerID(Employee managerID) {
		this.managerID = managerID;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setDepartmentID(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setDepartmentID(null);

		return employee;
	}

}