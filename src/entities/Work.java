package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Work {
	private String subject;
	private static SimpleDateFormat sdf1= new SimpleDateFormat("mm/DD");
	private Date deadline;
	public Work() {
	}
	public Work(String subject, Date deadline) {
		super();
		this.subject = subject;
		this.deadline = deadline;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "Work Home:\nsubject: "+subject+" || deadline: "+sdf1.format(deadline)+"\n";
	}
	
	
	
	
	
	
	

}
