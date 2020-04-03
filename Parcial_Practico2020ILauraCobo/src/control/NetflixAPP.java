package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import model.NetflixContent;
import model.NetflixMovie;
import model.NetflixSerie;

public class NetflixAPP {

	private static ArrayList<NetflixContent> content;

	public NetflixAPP() {
		content = new ArrayList<NetflixContent>();
	}

	public static void createTxt() {
		FileWriter file = null;
		PrintWriter pw = null;
		try {
			file = new FileWriter("./netflix_files/sortByYeay.txt");
			pw = new PrintWriter(file);
			
            sortByYear();
			for (int i = 0; i < content.size(); i++) {
				if(content.get(i) instanceof NetflixMovie) {
					NetflixMovie a = (NetflixMovie) content.get(i);
					String line = a.getName()+","+a.getYear()+","+a.getRating()+","+a.getType();
	                pw.println();
				}else if(content.get(i) instanceof NetflixSerie) {
					NetflixSerie a = (NetflixSerie) content.get(i);
					String line = a.getName()+","+a.getYear()+","+a.getRating()+","+a.getType();
	                pw.println();
				}
			}
			file.close();
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FileWriter file2 = null;
		PrintWriter pw2 = null;
		
		try {
			file2 = new FileWriter("./netflix_files/sortByRating.txt");
			pw2 = new PrintWriter(file2);
			
            sortByRating();
			for (int i = 0; i < content.size(); i++) {
				if(content.get(i) instanceof NetflixMovie) {
					NetflixMovie a = (NetflixMovie) content.get(i);
					String line = a.getName()+","+a.getYear()+","+a.getRating()+","+a.getType();
	                pw2.println();
				}else if(content.get(i) instanceof NetflixSerie) {
					NetflixSerie a = (NetflixSerie) content.get(i);
					String line = a.getName()+","+a.getYear()+","+a.getRating()+","+a.getType();
	                pw2.println();
				}
			}
			file2.close();
			pw2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Inspirado en el metodo burbuja encontrado en wikipedia
	public static void sortByRating() {
		int n = content.size();
		NetflixContent temp = null;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (content.get(j - 1).getRating() > content.get(j).getRating()) {
					temp = content.get(j - 1);
					content.add((j - 1), content.get(j));
					content.add(j, temp);
				}

			}
		}

	}

	public static void sortByYear() {
		int n = content.size();
		NetflixContent temp = null;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (content.get(j - 1).getYear() > content.get(j).getYear()) {
					temp = content.get(j - 1);
					content.add((j - 1), content.get(j));
					content.add(j, temp);
				}

			}
		}

	}

	public static void readFile() {
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {

			file = new File("./netflix_files/netflix.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				String[] a = line.split(",");
				if (a[3].equals(NetflixMovie.MOVIE_TYPE)) {
					NetflixMovie newMovie = new NetflixMovie(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2]),
							"./netflix_files/img/" + a[0].replace(" ", "") + ".jpg");
					content.add(newMovie);
				} else if (a[3].equals(NetflixSerie.SERIE_TYPE)) {
					NetflixSerie newSerie = new NetflixSerie(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2]),
							"./netflix_files/img/" + a[0].replace(" ", "") + ".jpg");
					content.add(newSerie);
				}
			}
			fr.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		readFile();
		createTxt();
		
	}

}
