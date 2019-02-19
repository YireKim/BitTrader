package service;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;
import sun.security.jca.GetInstance.Instance;

public class ImageServiceImpl implements ImageService{

	private static ImageServiceImpl Instance = new ImageServiceImpl();
	ImageServiceImpl dao;

	public ImageServiceImpl() {
		dao = ImageServiceImpl.getInstance();
	}

	public static ImageServiceImpl getInstance() {
		return Instance;
	}
	@Override
	public void addImage(ImageDTO img) {
	
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
		// TODO Auto-generated method stub
		return null;
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
	public void modifyImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removceImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}


}
