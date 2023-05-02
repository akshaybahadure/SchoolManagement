package schoolManagement.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class teachers 
{
	

	
	

		@Id
		private int tId;
		private String tName;
		private String subject;
		private int age;
		
		private String sEmail;
		private String sPass;
		
		public String getsEmail() {
			return sEmail;
		}
		public void setsEmail(String sEmail) {
			this.sEmail = sEmail;
		}
		public String getsPass() {
			return sPass;
		}
		public void setsPass(String sPass) {
			this.sPass = sPass;
		}
		public int gettId() {
			return tId;
		}
		public void settId(int tId) {
			this.tId = tId;
		}
		public String gettName() {
			return tName;
		}
		public void settName(String tName) {
			this.tName = tName;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}