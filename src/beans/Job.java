package beans;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the JOBS database table.
 * 
 */
@Entity
@Table(name="JOBS")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
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
		Job other = (Job) obj;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JOB_ID")
	private String jobId;

	@Column(name="JOB_TITLE")
	private String jobTitle;

	@Column(name="MAX_SALARY")
	private BigDecimal maxSalary;

	@Column(name="MIN_SALARY")
	private BigDecimal minSalary;

	public Job() {
	}

	
	public Job(String jobId, String jobTitle, BigDecimal maxSalary, BigDecimal minSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public BigDecimal getMaxSalary() {
		return this.maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

	public BigDecimal getMinSalary() {
		return this.minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

}