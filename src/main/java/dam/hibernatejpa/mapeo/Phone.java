package dam.hibernatejpa.mapeo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Entity
public class Phone {
	@Id
	@GeneratedValue
	private long id;
	
	private String number;
	
	@ManyToOne
	@JoinColumn(name="user_id",
		foreignKey=@ForeignKey(name="USER_ID_FK"))
	private User user;
	
	
	public Phone() {}
	public Phone(String number) {
		this.number = number;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
}
