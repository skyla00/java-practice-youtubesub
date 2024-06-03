package com.codestates.seb.youtubesub.V3;
import java.util.*;

public class YoutubeSub {
  //TODO:
  static final String ID = "admin";
  static final String PASSWORD = "0000";

  public static void main(String[] args) {
    // 사용자의 입력을 받기위한 Scanner s 객체 생성
    //TODO:
    Scanner sc = new Scanner(System.in);

    // 로그인 내용 확인
    // do while 문을 돌려서 아이디, 비밀번호가 확인이 안되면 다시 실행하도록 함.
    String inputId = "";
    String inputPw = "";
    do {
      System.out.printf("[시스템] 유튜브 계정의 아이디를 입력하세요 {Ex - admin} : ");
      inputId = sc.nextLine();
      System.out.printf("[시스템] 유튜브 계정의 비밀번호를 입력하세요{Ex - 0000} : ");
      inputPw = sc.nextLine();
      if (!inputPw.equals(PASSWORD) && !inputId.equals(ID) ) {
        // 로그인 정보가 다르다면 [경고] 문구 출력
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
  // ForbidMap의 금칙어, 순화어 를 Entry 로 돌며 subtitle 순화하기.
  private static String findForbid(String subtitle) {
    for(Map.Entry<String, String> entry: ForbidMap.datas.entrySet()) {
      String key = entry.getKey();
      String val = entry.getValue();
      subtitle = subtitle.replace(key, val);
    }
    return subtitle;
  }

  private static void printReplace(String subtitle) {
    System.out.println("=".repeat(30));
    System.out.println("[알림] 프로그램의 금칙어 리스트입니다.");
    System.out.println(ForbidMap.datas.keySet());
    System.out.println("=".repeat(30));
    System.out.println("[알림] 자막 순화 프로그램 결과입니다.");
    System.out.printf(">>> %s \n", subtitle );
    System.out.println("[안내] 프로그램을 종료합니다.");
    System.out.println("=".repeat(30));
  }
}