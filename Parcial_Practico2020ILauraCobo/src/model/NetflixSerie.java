package model;

public class NetflixSerie extends NetflixContent {

	public final static String SERIE_TYPE = "serie";
	private String type;
	
	public NetflixSerie(String name, int year, int rating, String imageURL) {
		super(name, year, rating,imageURL);
		type = SERIE_TYPE;
	}

	public String getType() {
		return type;
	}
	
	
}
