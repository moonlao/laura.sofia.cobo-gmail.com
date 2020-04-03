package model;

public class NetflixContent {
	
	private String name;
	private int year;
	private int rating;
	private String imageURL;
	
	public NetflixContent(String name, int year, int rating,String imageURL) {
		super();
		this.name = name;
		this.year = year;
		this.rating = rating;
		this.imageURL = imageURL;
	}

	
	
	public String getImageURL() {
		return imageURL;
	}


	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
