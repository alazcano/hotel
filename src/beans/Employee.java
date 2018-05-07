package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEES_EMPLOYEEID_GENERATOR", sequenceName="EMPLOYEES_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEES_EMPLOYEEID_GENERATOR")
	@Column(name="EMPLOYEE_ID")
	private long employeeId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (employeeId ^ (employeeId >>> 32));
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
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}

	@Column(name="COMMISSION_PCT")
	private BigDecimal commissionPct;

	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Temporal(TemporalType.DATE)
	@Column(name="HIRE_DATE")
	private Date hireDate;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	private BigDecimal salary;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department departmentID;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private Employee coordinador;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="coordinador")
	private List<Employee> minions;

	//uni-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;

	public Employee() {
	}
	
	public Employee(long employeeId, BigDecimal commissionPct, String email, String firstName,
			String lastName, String phoneNumber, BigDecimal salary, Department departmentID, Employee coordinador,
			Job job) {
		super();
		this.employeeId = employeeId;
		this.commissionPct = commissionPct;
		this.email = email;
		this.firstName = firstName;
		this.hireDate = new Date();
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.departmentID = departmentID;
		this.coordinador = coordinador;
		
		this.job = job;
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Department getDepartmentID() {
		return this.departmentID;
	}

	public void setDepartmentID(Department departmentID) {
		this.departmentID = departmentID;
	}

	public Employee getCoordinador() {
		return this.coordinador;
	}

	public void setCoordinador(Employee coordinador) {
		this.coordinador = coordinador;
	}

	public List<Employee> getMinions() {
		return this.minions;
	}

	public void setMinions(List<Employee> minions) {
		this.minions = minions;
	}

	public Employee addMinion(Employee minion) {
		getMinions().add(minion);
		minion.setCoordinador(this);

		return minion;
	}

	public Employee removeMinion(Employee minion) {
		getMinions().remove(minion);
		minion.setCoordinador(null);

		return minion;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}