package model;

public class NetflixMovie extends NetflixContent{
	
	public final static String MOVIE_TYPE = "movie";
	private String type;

	public NetflixMovie(String name, int year, int rating, String imageURL) {
		super(name, year, rating,imageURL);
		type = MOVIE_TYPE;
	}

	public String getType() {
		return type;
	}
	
}
