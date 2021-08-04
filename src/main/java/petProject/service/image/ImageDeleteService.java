/*
========================================================================
파    일    명 : ImageDeleteService.java
========================================================================
작    성    자 : 강지호
작    성    일 : 2020.xx.xx
작  성  내  용 : 이미지리스트를 삭제하는 메서드 인터페이스
========================================================================
*/
package petProject.service.image;

public interface ImageDeleteService {

	void deleteImage(String[] paths_id, String rootPath) throws Exception;
}
