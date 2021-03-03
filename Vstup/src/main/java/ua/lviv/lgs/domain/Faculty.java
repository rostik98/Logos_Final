package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private Double passingScore;
	@Column
	private Integer budgetPlaces;

	/**
	 * @return the entrants
	 */

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", passingScore=" + passingScore + ", budgetPlaces="
				+ budgetPlaces + "]";
	}

	/**
	 * 
	 */
	public Faculty() {
	}

	/**
	 * @param id
	 * @param name
	 * @param passingScore
	 * @param budgetPlaces
	 */
	public Faculty(Integer id, String name, Double passingScore, Integer budgetPlaces) {
		super();
		this.id = id;
		this.name = name;
		this.passingScore = passingScore;
		this.budgetPlaces = budgetPlaces;
	}

	public Faculty(String name, Double passingScore, Integer budgetPlaces) {
		this.name = name;
		this.passingScore = passingScore;
		this.budgetPlaces = budgetPlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budgetPlaces == null) ? 0 : budgetPlaces.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passingScore == null) ? 0 : passingScore.hashCode());
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
		Faculty other = (Faculty) obj;
		if (budgetPlaces == null) {
			if (other.budgetPlaces != null)
				return false;
		} else if (!budgetPlaces.equals(other.budgetPlaces))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passingScore == null) {
			if (other.passingScore != null)
				return false;
		} else if (!passingScore.equals(other.passingScore))
			return false;
		return true;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the passingScore
	 */
	public Double getPassingScore() {
		return passingScore;
	}

	/**
	 * @param passingScore the passingScore to set
	 */
	public void setPassingScore(Double passingScore) {
		this.passingScore = passingScore;
	}

	/**
	 * @return the budgetPlaces
	 */
	public Integer getBudgetPlaces() {
		return budgetPlaces;
	}

	/**
	 * @param budgetPlaces the budgetPlaces to set
	 */
	public void setBudgetPlaces(Integer budgetPlaces) {
		this.budgetPlaces = budgetPlaces;
	}
}
