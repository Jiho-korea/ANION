package petProject.vo;

public class ImageUploadRequest {

	private static final long serialVersionUID = 1L;

	private String ownerId;
	private int petRegistrationNumber;
	private String imagePath;

	public ImageUploadRequest(String ownerId, int petRegistrationNumber, String imagePath) {
		super();
		this.ownerId = ownerId;
		this.petRegistrationNumber = petRegistrationNumber;
		this.imagePath = imagePath;
	}

	public ImageUploadRequest() {
		super();
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public int getPetRegistrationNumber() {
		return petRegistrationNumber;
	}

	public void setPetRegistrationNumber(int petRegistrationNumber) {
		this.petRegistrationNumber = petRegistrationNumber;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
