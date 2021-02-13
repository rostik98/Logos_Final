package ua.lviv.lgs.domain;

public class Enrolled {
	private Integer facultyId;
	private Integer entrantId;
	private Double competitiveScore;

	@Override
	public String toString() {
		return "Enrolled [facultyId=" + facultyId + ", entrantId=" + entrantId + ", competitiveScore="
				+ competitiveScore + "]";
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
	public Enrolled(Integer facultyId, Integer entrantId, Double competitiveScore) {
		super();
		this.facultyId = facultyId;
		this.entrantId = entrantId;
		this.competitiveScore = competitiveScore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competitiveScore == null) ? 0 : competitiveScore.hashCode());
		result = prime * result + ((entrantId == null) ? 0 : entrantId.hashCode());
		result = prime * result + ((facultyId == null) ? 0 : facultyId.hashCode());
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
		if (entrantId == null) {
			if (other.entrantId != null)
				return false;
		} else if (!entrantId.equals(other.entrantId))
			return false;
		if (facultyId == null) {
			if (other.facultyId != null)
				return false;
		} else if (!facultyId.equals(other.facultyId))
			return false;
		return true;
	}

	/**
	 * @return the facultyId
	 */
	public Integer getFacultyId() {
		return facultyId;
	}

	/**
	 * @param facultyId the facultyId to set
	 */
	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
	}

	/**
	 * @return the entrantId
	 */
	public Integer getEntrantId() {
		return entrantId;
	}

	/**
	 * @param entrantId the entrantId to set
	 */
	public void setEntrantId(Integer entrantId) {
		this.entrantId = entrantId;
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
