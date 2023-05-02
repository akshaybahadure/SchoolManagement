package schoolManagement.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class subjects {

		@Id
		private int subId;
		private String subName;
		private int marks;
		
		public int getSubId() {
			return subId;
		}
		public void setSubId(int subId) {
			this.subId = subId;
		}
		public String getSubName() {
			return subName;
		}
		public void setSubName(String subName) {
			this.subName = subName;
		}
		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
		
		
	}
