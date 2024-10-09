package services;

import java.util.List;

import dao.IVideoDao;
import dao.VideoDao;
import entity.Video;

public class VideoService implements IVideoService {
	IVideoDao dao = new VideoDao();

	@Override
	public int count() {
		return dao.count();
	}

	@Override
	public List<Video> findAll(int page, int pagesize) {
		return dao.findAll(page, pagesize);
	}

	@Override
	public List<Video> findByVideoTitle(String title) {
		return dao.findByVideoTitle(title);
	}

	@Override
	public List<Video> findAll() {
		return dao.findAll();
	}

	@Override
	public Video findById(String videoid) {
		return dao.findById(videoid);
	}

	@Override
	public void delete(String videoid) throws Exception {
		dao.delete(videoid);

	}

	@Override
	public void update(Video Video) {
		dao.update(Video);

	}

	@Override
	public void insert(Video Video) {
		dao.insert(Video);

	}

}
