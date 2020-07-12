package fr.cesi.qcm.dto;

public class TodoDTO {

    public String title;
	
	public TodoDTO() {		
	}

	public TodoDTO(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "TodoDTO [title=" + title + "]";
	}
}
