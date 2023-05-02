package schoolManagement.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class students
{
		@Id
		private int sId;
		private String sName;
		private String DOB;
		private long cno;
		private String sEmail;
		private String sPass;
		
		@OneToMany
		List<subjects> subjects;
		
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
		public List<subjects> getSubjects() {
			return subjects;
		}
		public void setSubjects(List<subjects> subjects) {
			this.subjects = subjects;
		}
		public int getsId() {
			return sId;
		}
		public void setsId(int sId) {
			this.sId = sId;
		}
		public String getsName() {
			return sName;
		}
		public void setsName(String sName) {
			this.sName = sName;
		}
		public String getDOB() {
			return DOB;
		}
		public void setDOB(String dOB) {
			DOB = dOB;
		}
		public long getCno() {
			return cno;
		}
		public void setCno(long cno) {
			this.cno = cno;
		}
		
		
	}