package service;

import java.util.List;

import dao.ImageDAOImpl;
import domain.ImageDTO;
import proxy.Proxy;

public class ImageServiceImpl implements ImageService{

	private static ImageServiceImpl Instance = new ImageServiceImpl();
	ImageDAOImpl dao;

	public ImageServiceImpl() {
		dao = ImageDAOImpl.getInstance();
	}

	public static ImageServiceImpl getInstance() {
		return Instance;
	}

	@Override
	public void addImage(ImageDTO img) {
		dao.insertImage(img);
	}

	@Override
	public ImageDTO updateImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageDTO> retrieveAllImage(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageDTO> retrieveSomeImage(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDTO retrieveAnImage(ImageDTO img) {
		return dao.selectAnImage(img);
	}

	@Override
	public int countImage(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existImage(ImageDTO img) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyImage(Proxy pxy) {
		dao.updateImage(pxy);
	}

	@Override
	public void removceImage(Proxy pxy) {
		// TODO Auto-generated method stub
		
	}


}
