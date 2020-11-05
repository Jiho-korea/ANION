package petProject.vo;

public class Image {
	private static final long serialVersionUID = 1L;
	private int petRegistrationNumber;
	private String imagePath;
	private String ownerId;
	private int imageNumber;

	public Image(int petRegistrationNumber, String imagePath, String ownerId, int imageNumber) {
		super();
		this.petRegistrationNumber = petRegistrationNumber;
		this.imagePath = imagePath;
		this.ownerId = ownerId;
		this.imageNumber = imageNumber;
	}

	public Image() {
		super();
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

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
