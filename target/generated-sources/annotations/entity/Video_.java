package entity;

import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Video.class)
public abstract class Video_ {

	public static final String QUERY_VIDEO_FIND_ALL = "Video.findAll";
	public static final String ACTIVE = "active";
	public static final String DESCRIPTION = "description";
	public static final String VIDEOID = "videoid";
	public static final String TITLE = "title";
	public static final String CATEGORY = "category";
	public static final String POSTER = "poster";
	public static final String VIEWS = "views";

	
	/**
	 * @see entity.Video#active
	 **/
	public static volatile SingularAttribute<Video, Integer> active;
	
	/**
	 * @see entity.Video#description
	 **/
	public static volatile SingularAttribute<Video, String> description;
	
	/**
	 * @see entity.Video#videoid
	 **/
	public static volatile SingularAttribute<Video, String> videoid;
	
	/**
	 * @see entity.Video#title
	 **/
	public static volatile SingularAttribute<Video, String> title;
	
	/**
	 * @see entity.Video#category
	 **/
	public static volatile SingularAttribute<Video, Category> category;
	
	/**
	 * @see entity.Video
	 **/
	public static volatile EntityType<Video> class_;
	
	/**
	 * @see entity.Video#poster
	 **/
	public static volatile SingularAttribute<Video, String> poster;
	
	/**
	 * @see entity.Video#views
	 **/
	public static volatile SingularAttribute<Video, Integer> views;

}

