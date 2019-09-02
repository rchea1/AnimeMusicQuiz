package com.knotts.animemusicquiz.animemusicquiz.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Theme")
public class Theme {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="video_url")
	private String url;
	
	@Column(name="theme_type")
	private String themeType;
	
	@Column(name="theme_number")
	private String themeNumber;
	
	@Column(name="artist")
	private String artist;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="anime_id")
	private Anime anime;
	
	public Theme() {
		
	}

	public Theme(String title, String url, String themeType, String themeNumber, String artist) {
		this.title = title;
		this.url = url;
		this.themeType = themeType;
		this.themeNumber = themeNumber;
		this.artist = artist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThemeType() {
		return themeType;
	}

	public void setThemeType(String themeType) {
		this.themeType = themeType;
	}

	public String getThemeNumber() {
		return themeNumber;
	}

	public void setThemeNumber(String themeNumber) {
		this.themeNumber = themeNumber;
	}

	public Anime getAnime() {
		return anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", title=" + title + ", url=" + url + ", themeType=" + themeType + ", themeNumber="
				+ themeNumber + ", artist=" + artist + "]";
	}
}
	