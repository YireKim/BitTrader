package enums;

public enum ImageSQL {

	UPLOAD_IMAGE, LAST_IMG_SEQ, SELECT_IMG;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		System.out.println(" .. IMG SQL");
		switch (this) {
		case UPLOAD_IMAGE:
			query.append("INSERT INTO IMAGE (IMAGE_ID, IMAGE_NAME, IMAGE_EXTENTION, IMAGE_OWNER) VALUES(IMG_SEQ.NEXTVAL, ?, ?, ?)");
			break;
			
		case LAST_IMG_SEQ:
			query.append("SELECT MAX(IMAGE_ID) AS IMG_SEQ FROM IMAGE");
			break;
			
		case SELECT_IMG:
			System.out.println("@@@@@@@ ImageSQL :: SELECT IMG SQL");
			query.append("SELECT * FROM IMAGE WHERE IMAGE_OWNER LIKE ?");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
