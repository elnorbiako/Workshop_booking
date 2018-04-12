package pl.coderslab.entity;

import pl.coderslab.dao.StatusDao;

public class Status extends StatusDao{
	
	private Integer id;
    private String name;
    

	public Status(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Status() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	} 
    

}
