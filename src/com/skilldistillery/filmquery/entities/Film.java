package com.skilldistillery.filmquery.entities;

import java.util.List;

public class Film {
	private List<Actor> actors;
	private Integer id;
	private String title;
	private String description;
	private Integer releaseYear;
	private Integer languageId;
	private Integer rentalDuration;
	private Double rentalRate;
	private Integer length;
	private Double replacementCost;
	private String rating;
	private String specialFeatures;

	public Film(Integer id, String title, String description, Integer releaseYear, Integer languageId,
			Integer rentalDuration, Double rentalRate, Integer length, Double replacementCost, String rating,
			String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public Double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(Double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(Double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((languageId == null) ? 0 : languageId.hashCode());
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		result = prime * result + ((rentalDuration == null) ? 0 : rentalDuration.hashCode());
		result = prime * result + ((rentalRate == null) ? 0 : rentalRate.hashCode());
		result = prime * result + ((replacementCost == null) ? 0 : replacementCost.hashCode());
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (languageId == null) {
			if (other.languageId != null)
				return false;
		} else if (!languageId.equals(other.languageId))
			return false;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		if (rentalDuration == null) {
			if (other.rentalDuration != null)
				return false;
		} else if (!rentalDuration.equals(other.rentalDuration))
			return false;
		if (rentalRate == null) {
			if (other.rentalRate != null)
				return false;
		} else if (!rentalRate.equals(other.rentalRate))
			return false;
		if (replacementCost == null) {
			if (other.replacementCost != null)
				return false;
		} else if (!replacementCost.equals(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [id=");
		builder.append(id);
		builder.append("\n title=");
		builder.append(title);
		builder.append("\n description=");
		builder.append(description);
		builder.append("\n releaseYear=");
		builder.append(releaseYear);
		builder.append("\n languageId=");
		builder.append(languageId);
		builder.append("\n rentalDuration=");
		builder.append(rentalDuration);
		builder.append("\n rentalRate=");
		builder.append(rentalRate);
		builder.append("\n length=");
		builder.append(length);
		builder.append("\n replacementCost=");
		builder.append(replacementCost);
		builder.append("\n rating=");
		builder.append(rating);
		builder.append("\n specialFeatures=");
		builder.append(specialFeatures);
		builder.append("]");
		return builder.toString();
	}

}
