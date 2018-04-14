package pl.coderslab.entity;

import java.sql.Date;
import java.sql.Timestamp;

import pl.coderslab.dao.ReservationDao;

public class Reservation extends ReservationDao{
	
	private Integer id;
    private Date created; 
    private String dateFrom;
    private String dateTo;
    private String description;
    private int statusId;
    private int userId;
    private int roomId;
    
    
    
	public Reservation(String date_from, String date_to, String description, int statusId,int userId, int roomId) {
		super();
		
		this.dateFrom = date_from;
		this.dateFrom = date_to;
		this.description = description;
		this.statusId = statusId;
		this.userId = userId;
		this.roomId = roomId;
	}



	public Reservation() {
		super();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getCreated() {
		return created;
	}



	public void setCreated(Date created) {
		this.created = created;
	}



	public String getDateFrom() {
		return dateFrom;
	}



	public void setDateFrom(String date_from) {
		this.dateFrom = date_from;
	}



	public String getDateTo() {
		return dateFrom;
	}



	public void setDateTo(String date_to) {
		this.dateFrom = date_to;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getStatusId() {
		return statusId;
	}



	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getRoomId() {
		return roomId;
	}



	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}



	@Override
	public String toString() {
		return "Reservation [id=" + id + ", created=" + created + ", dateFrom=" + dateFrom + ", dateTo=" + dateTo
				+ ", description=" + description + ", statusId=" + statusId + ", userId=" + userId + ", roomId="
				+ roomId + "]";
	}
		
    

}
