package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mark")
public class Mark {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "entrant_id", referencedColumnName = "id")
	private Entrant entrant;
	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private Subject subject;
	@Column(name = "value")
	private Integer value;

	@Override
	public String toString() {
		return "Mark [entrantId=" + entrant + ", subjectId=" + subject + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrant == null) ? 0 : entrant.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Mark other = (Mark) obj;
		if (entrant == null) {
			if (other.entrant != null)
				return false;
		} else if (!entrant.equals(other.entrant))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/**
	 * 
	 */
	public Mark() {
	}

	/**
	 * @param entrantId
	 * @param subjectId
	 * @param value
	 */
	public Mark(Entrant entrantId, Subject subjectId, Integer value) {
		super();
		this.entrant = entrantId;
		this.subject = subjectId;
		this.value = value;
	}

	/**
	 * @return the entrantId
	 */
	public Entrant getEntrantId() {
		return entrant;
	}

	/**
	 * @param entrantId the entrantId to set
	 */
	public void setEntrantId(Entrant entrantId) {
		this.entrant = entrantId;
	}

	/**
	 * @return the subjectId
	 */
	public Subject getSubjectId() {
		return subject;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(Subject subjectId) {
		this.subject = subjectId;
	}

	/**
	 * @return the value
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
}
