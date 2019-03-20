package org.niraj.txn1;

public class MovieTicket {

	private int movieId;
	private String movieName;
	private int totalTicketsCount;
	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getTotalTicketsCount() {
		return totalTicketsCount;
	}
	public void setTotalTicketsCount(int totalTicketsCount) {
		this.totalTicketsCount = totalTicketsCount;
	}
	
	
}
