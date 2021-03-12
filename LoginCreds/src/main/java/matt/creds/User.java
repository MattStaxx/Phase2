package matt.creds;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;

@Entity
@Table(name = "login_creds")

public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "password")
    private String password;
        
        public String getName() { return this.name;}
        public String getPassword() { return this.password;}
        
        public void setName(String name) { this.name = name;}
        public void setPassword(String password) { this.password = password;}
}