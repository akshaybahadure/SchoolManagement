package schoolManagement.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class management 
{
	
	
		@Id
		private int id;
		private String email;
		private String password;
		
		@OneToMany
		private List<teachers> teachers;
		@OneToMany
		private List<students> students;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public List<teachers> getTeachers() {
			return teachers;
		}
		public void setTeachers(List<teachers> teachers) {
			this.teachers = teachers;
		}
		public List<students> getStudents() {
			return students;
		}
		public void setStudents(List<students> students) {
			this.students = students;
		}
		
	}