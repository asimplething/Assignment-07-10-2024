package services;

import java.util.List;

import entity.Video;

public interface IVideoService {
	int count();

	List<Video> findAll(int page, int pagesize);

	List<Video> findByVideoTitle(String title);

	List<Video> findAll();

	Video findById(String videoid);

	void delete(String videoid) throws Exception;

	void update(Video Video);

	void insert(Video Video);
}
