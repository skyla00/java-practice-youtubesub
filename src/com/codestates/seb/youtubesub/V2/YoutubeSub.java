package com.codestates.seb.youtubesub.V2;
import java.util.Arrays;
import java.util.Scanner;

public class YoutubeSub {
  //TODO:
  /**
   * 관리자의 계정 정보는 다음과 같이 변하지 않도록 정의하여 줍니다.
   * static final 과 final static 은 차이가 없습니다.
   * 다만 static final 이 눈에 익숙합니다.
   * */
  static final String ID = "admin";
  static final String PASSWORD = "0000";
  /**
   * @static 은 별도의 객체 생성 없이 바로 사용이 가능 합니다.
   * 본 프로그램의 금칙어 리스트와 대체어 리스트를 배열로 정의합니다.
   */
  static final String [] forbid = new String[] {"킹", "시발", "꺼저", "미친", "죽어"};
  static final String [] replace = new String[] {"아", "할 수 있어", "사랑", "열받네", "희망"};
  public static void main(String[] args) {
    // 사용자의 입력을 받기위한 Scanner s 객체 생성
    //TODO:
    Scanner sc = new Scanner(System.in);

    String inputId = "";
    String inputPw = "";

    // do while 문을 돌려서 아이디, 비밀번호가 확인이 안되면 다시 실행하도록 함.
    do {
      System.out.printf("[시스템] 유튜브 계정의 아이디를 입력하세요 {Ex - admin} : ");
      inputId = sc.nextLine();
      System.out.printf("[시스템] 유튜브 계정의 비밀번호를 입력하세요{Ex - 0000} : ");
      inputPw = sc.nextLine();
      if (!inputPw.equals(PASSWORD) && !inputId.equals(ID) ) {
        // 로그인 정보가 다르다면 [경고] 문구 출력 및 조기 리턴
        System.out.println("[[경고] 유튜브 계정의 아이디 및 비밀번호를 다시 확인해 주세요.");
      }
    } while (!inputId.equals(ID) || !inputPw.equals(PASSWORD) );
    System.out.printf("[[안내] 안녕하세요. %s 님 \n", ID );
    System.out.println("[시스템] 유튜브 자막을 생성해주세요.");
    inputSubtitle(sc.nextLine());
  }
  private static void inputSubtitle(String subtitle) {
    printReplace(findForbid(subtitle));
  }
  // 금칙어를 대체어로 전환하는 과정은 다음과 같습니다.
  // 1. 금칙어 배열에서 하나씩 불러옵니다.
  // 2. 해당 금칙어가 자막에 포함되어 있는지 확인합니다.
  // 3. 만약 포함되어 있다면 replace()를 통해 금칙어와 대체어를 전환하여 저장합니다.
  private static String findForbid(String subtitle) {
    for (int i = 0; i < forbid.length ; i++) {
      subtitle = subtitle.replace(forbid[i], replace[i]);
    }
    return subtitle;
  }

  private static void printReplace(String subtitle) {
    System.out.println("=".repeat(30));
    System.out.println("[알림] 프로그램의 금칙어 리스트입니다.");
    System.out.println(Arrays.toString(forbid));
    System.out.println("=".repeat(30));
    System.out.println("[알림] 자막 순화 프로그램 결과입니다.");
    System.out.printf(">>> %s \n", subtitle );
    System.out.println("[안내] 프로그램을 종료합니다.");
    System.out.println("=".repeat(30));
  }
}