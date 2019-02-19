package dao;

import java.util.List;

import domain.ImageDTO;
import proxy.ImageProxy;
import proxy.Proxy;

public interface ImageDAO {
	// CREATE
	public void insertImage(ImageDTO img);
	
	// READ
	public List<ImageDTO> selectListOfImage(Proxy pxy);
	public List<ImageDTO> selectSomeOfImage(ImageDTO img);
	public ImageDTO selectAnImage(ImageDTO img);
	public String recentImageSeq();
	public int countImage(Proxy pxy);
	public boolean existImageSeq(ImageDTO img);
	
	// UPDATE
	public void updateImage(ImageDTO img);
	
	// DELETE
	public void deleteImage(ImageDTO img);

}

