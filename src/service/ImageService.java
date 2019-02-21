package service;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageService {

	// CREATE
	public void addImage(ImageDTO img);
	
	public ImageDTO updateImage(); 

	// READ
	public List<ImageDTO> retrieveAllImage(Proxy pxy);
	public List<ImageDTO> retrieveSomeImage(Proxy pxy);
	public ImageDTO retrieveAnImage(ImageDTO img);

	public int countImage(Proxy pxy);
	public boolean existImage(ImageDTO img);
	
	// UPDATE
	public void modifyImage(Proxy pxy);
	
	// DELETE
	public void removceImage(Proxy pxy);
	
}

