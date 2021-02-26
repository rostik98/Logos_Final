package ua.lviv.lgs.domain;

import javax.persistence.CascadeType;
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
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "entrant_id", referencedColumnName = "id")
	private Entrant entrant;
//	@OneToOne
//	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	@Column(name = "subject_id")
	private Integer subject_id;
	@Column(name = "value")
	private Integer value;

	@Override
	public String toString() {
		return "Mark [entrantId=" + entrant + ", subjectId=" + subject_id + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrant == null) ? 0 : entrant.hashCode());
		result = prime * result + ((subject_id == null) ? 0 : subject_id.hashCode());
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
		if (subject_id == null) {
			if (other.subject_id != null)
				return false;
		} else if (!subject_id.equals(other.subject_id))
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
	public Mark(Entrant entrantId, Integer subjectId, Integer value) {
		super();
		this.entrant = entrantId;
		this.subject_id = subjectId;
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
	public Integer getSubjectId() {
		return subject_id;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(Integer subjectId) {
		this.subject_id = subjectId;
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
