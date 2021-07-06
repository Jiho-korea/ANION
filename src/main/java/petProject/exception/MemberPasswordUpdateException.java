/*
========================================================================
파    일    명 : MemberPasswordUpdateException.java
========================================================================
작    성    자 : 송찬영
작    성    일 : 2021.07.03
작  성  내  용 : 비밀번호 업데이트 오류 익셉션
========================================================================
 */
package petProject.exception;

public class MemberPasswordUpdateException extends RuntimeException {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   public MemberPasswordUpdateException(String message) {
      super(message);
   }
}