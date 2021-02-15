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
@Table(name = "enrolled")
public class Enrolled {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "faculty_id", referencedColumnName = "id")
	private Faculty faculty;
	@ManyToOne
	@JoinColumn(name = "entrant_id", referencedColumnName = "id")
	private Entrant entrant;
	@Column(name = "comp_score")
	private Double competitiveScore;

	@Override
	public String toString() {
		return "Enrolled [facultyId=" + faculty + ", entrantId=" + entrant + ", competitiveScore=" + competitiveScore
				+ "]";
	}

	/**
	 * 
	 */
	public Enrolled() {
	}

	/**
	 * @param facultyId
	 * @param entrantId
	 * @param competitiveScore
	 */
	public Enrolled(Faculty facultyId, Entrant entrantId, Double competitiveScore) {
		super();
		this.faculty = facultyId;
		this.entrant = entrantId;
		this.competitiveScore = competitiveScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competitiveScore == null) ? 0 : competitiveScore.hashCode());
		result = prime * result + ((entrant == null) ? 0 : entrant.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
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
		Enrolled other = (Enrolled) obj;
		if (competitiveScore == null) {
			if (other.competitiveScore != null)
				return false;
		} else if (!competitiveScore.equals(other.competitiveScore))
			return false;
		if (entrant == null) {
			if (other.entrant != null)
				return false;
		} else if (!entrant.equals(other.entrant))
			return false;
		if (faculty == null) {
			if (other.faculty != null)
				return false;
		} else if (!faculty.equals(other.faculty))
			return false;
		return true;
	}

	/**
	 * @return the facultyId
	 */
	public Faculty getFacultyId() {
		return faculty;
	}

	/**
	 * @param facultyId the facultyId to set
	 */
	public void setFacultyId(Faculty facultyId) {
		this.faculty = facultyId;
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
	 * @return the competitiveScore
	 */
	public Double getCompetitiveScore() {
		return competitiveScore;
	}

	/**
	 * @param competitiveScore the competitiveScore to set
	 */
	public void setCompetitiveScore(Double competitiveScore) {
		this.competitiveScore = competitiveScore;
	}
}
