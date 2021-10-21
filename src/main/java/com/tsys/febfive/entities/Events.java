	package com.tsys.febfive.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Events {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer eventId;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String discription;

	@Column(nullable = false)
	private String venue;

	@Column(nullable = true)
	private LocalDateTime fromDt = LocalDateTime.now();

	@Column(nullable = true)
	private LocalDateTime toDt = LocalDateTime.now();
	
	@Column(nullable = true)
	private LocalDateTime createdDt = LocalDateTime.now();
	
	@Column(nullable = true)
	private LocalDateTime updateDt =LocalDateTime.now();

	@Column(nullable = false)
	private Integer userId;
	
	@Column
	private String userName;
	
	@Column(nullable = true)
	private Integer categortId = 0;

	@Column(nullable = true)
	private Integer subCategoryId = 0;
	
	public Events() {}
	
	public Events(Integer eventId, String title, String discription, String venue, LocalDateTime fromDt,
			LocalDateTime toDt, LocalDateTime createdDt, LocalDateTime updateDt, Integer userId,
			Integer subCategoryId) {
		super();
		this.eventId = eventId;
		this.title = title;
		this.discription = discription;
		this.venue = venue;
		this.fromDt = fromDt;
		this.toDt = toDt;
		this.createdDt = createdDt;
		this.updateDt = updateDt;
		this.userId = userId;
		this.subCategoryId = subCategoryId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public LocalDateTime getFromDt() {
		return fromDt;
	}

	public void setFromDt(LocalDateTime fromDt) {
		this.fromDt = fromDt;
	}

	public LocalDateTime getToDt() {
		return toDt;
	}

	public void setToDt(LocalDateTime toDt) {
		this.toDt = toDt;
	}

	public LocalDateTime getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}

	public LocalDateTime getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(LocalDateTime updateDt) {
		this.updateDt = updateDt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCategortId() {
		return categortId;
	}

	public void setCategortId(Integer categortId) {
		this.categortId = categortId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdDt == null) ? 0 : createdDt.hashCode());
		result = prime * result + ((discription == null) ? 0 : discription.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((fromDt == null) ? 0 : fromDt.hashCode());
		result = prime * result + ((subCategoryId == null) ? 0 : subCategoryId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((toDt == null) ? 0 : toDt.hashCode());
		result = prime * result + ((updateDt == null) ? 0 : updateDt.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((venue == null) ? 0 : venue.hashCode());
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
		Events other = (Events) obj;
		if (createdDt == null) {
			if (other.createdDt != null)
				return false;
		} else if (!createdDt.equals(other.createdDt))
			return false;
		if (discription == null) {
			if (other.discription != null)
				return false;
		} else if (!discription.equals(other.discription))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (fromDt == null) {
			if (other.fromDt != null)
				return false;
		} else if (!fromDt.equals(other.fromDt))
			return false;
		if (subCategoryId == null) {
			if (other.subCategoryId != null)
				return false;
		} else if (!subCategoryId.equals(other.subCategoryId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (toDt == null) {
			if (other.toDt != null)
				return false;
		} else if (!toDt.equals(other.toDt))
			return false;
		if (updateDt == null) {
			if (other.updateDt != null)
				return false;
		} else if (!updateDt.equals(other.updateDt))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (venue == null) {
			if (other.venue != null)
				return false;
		} else if (!venue.equals(other.venue))
			return false;
		return true;
	}
}
