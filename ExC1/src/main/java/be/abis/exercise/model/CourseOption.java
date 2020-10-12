package be.abis.exercise.model;

public class CourseOption {
	
	private String selectedItem;
	private String selectedArgument;
	
	public CourseOption(String selectedItem, String selectedArgument) {
		super();
		this.selectedItem = selectedItem;
		this.selectedArgument = selectedArgument;
	}
	
	public CourseOption() {
		
	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

	public String getSelectedArgument() {
		return selectedArgument;
	}

	public void setSelectedArgument(String selectedArgument) {
		this.selectedArgument = selectedArgument;
	}

	
	
}
