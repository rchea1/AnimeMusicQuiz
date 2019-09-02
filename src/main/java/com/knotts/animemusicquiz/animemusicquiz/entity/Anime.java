package com.knotts.animemusicquiz.animemusicquiz.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="anime")
public class Anime {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="premiere_year")
	private String premiereYear;
	
	@Column(name="premiere_season")
	private String premiereSeason;
	
	@JsonIgnore
	@OneToMany(mappedBy="anime", cascade=CascadeType.MERGE)
	private Set<Theme> themes;
	
	@OneToMany(mappedBy="anime", cascade=CascadeType.MERGE)
	private Set<AlternativeName> alternativeNames;

	public Anime() {
		
	}

	public Anime(String title, String premiereYear, String premiereSeason) {
		this.title = title;
		this.premiereYear = premiereYear;
		this.premiereSeason = premiereSeason;
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

	public String getPremiereYear() {
		return premiereYear;
	}

	public void setPremiereYear(String premiereYear) {
		this.premiereYear = premiereYear;
	}

	public String getPremiereSeason() {
		return premiereSeason;
	}

	public void setPremiereSeason(String premiereSeason) {
		this.premiereSeason = premiereSeason;
	}

	public Set<AlternativeName> getAlternativeNames() {
		return alternativeNames;
	}

	public void setAlternativeNames(Set<AlternativeName> alternativeNames) {
		this.alternativeNames = alternativeNames;
	}

	public Set<Theme> getThemes() {
		return themes;
	}

	public void setThemes(Set<Theme> themes) {
		this.themes = themes;
	}
	
	public void addTheme(Theme theme) {
		if(themes == null) {
			themes = new HashSet<>();
		}
		
		themes.add(theme);
	}
	
	public void removeTheme(Theme theme) {
		if(themes == null) {
			return;
		}
		
		themes.remove(theme);
	}
	
	public void addAlternativeName(AlternativeName alternativeName) {
		if(alternativeNames == null) {
			alternativeNames = new HashSet<>();
		}
		alternativeNames.add(alternativeName);
	}
	
	public void removeAlternativeName(AlternativeName alternativeName) {
		if(alternativeNames == null) {
			return;
		}
		
		alternativeNames.remove(alternativeName);
	}

	@Override
	public String toString() {
		return "Anime [id=" + id + ", title=" + title + ", premiereYear=" + premiereYear + ", premiereSeason="
				+ premiereSeason + ", themes=" + themes + ", alternativeNames=" + alternativeNames + "]";
	}
}
