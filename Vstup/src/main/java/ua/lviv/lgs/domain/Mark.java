package ua.lviv.lgs.domain;

public class Mark {
	private Integer entrantId;
	private Integer subjectId;
	private Integer value;

	@Override
	public String toString() {
		return "Mark [entrantId=" + entrantId + ", subjectId=" + subjectId + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entrantId == null) ? 0 : entrantId.hashCode());
		result = prime * result + ((subjectId == null) ? 0 : subjectId.hashCode());
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
		if (entrantId == null) {
			if (other.entrantId != null)
				return false;
		} else if (!entrantId.equals(other.entrantId))
			return false;
		if (subjectId == null) {
			if (other.subjectId != null)
				return false;
		} else if (!subjectId.equals(other.subjectId))
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
	public Mark(Integer entrantId, Integer subjectId, Integer value) {
		super();
		this.entrantId = entrantId;
		this.subjectId = subjectId;
		this.value = value;
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
	 * @return the subjectId
	 */
	public Integer getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
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
