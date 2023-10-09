import java.util.Scanner;
public class MonthSchedule {
  private int nDays;
  private Day[] days;
  private Scanner scanner;

  public MonthSchedule(int nDays) {
    this.nDays = nDays;
    this.days = new Day[nDays];
    for(int i=0; i<days.length; i++)
      days[i] = new Day();
    scanner = new Scanner(System.in);
  }

  private void input() {
    System.out.print("날짜(1~"+nDays+"?");
    int day = scanner.nextInt();
    System.out.print("할일?");
    //String work = scanner.next();
    scanner.nextLine();//버퍼에 enter가 남는건 next는 무시하지만 nextLine은 민감히 반응
    String work = scanner.nextLine();
    day--;
    if(day<0 || day> nDays) {
      System.out.println("날짜 오류");
      return;
    }
    days[day].set(work);
  }
  private void view() {
    System.out.print("날짜(1~"+nDays+"?");
    int day = scanner.nextInt();
    day--;
    if(day<0 || day> nDays) {
      System.out.println("날짜 오류");
      return;
  }
    System.out.print( (day+1) + "일의 할 일은 ");
    days[day].show();
}
  private void finish() {
    scanner.close();
    System.out.println("프로그램 종료");
  }
  public void run() {
    System.out.println("스케쥴 관리 프로그램");
    while(true) {
      System.out.print("할일(1:입력, 2:보기, 3:종료)");
      int menu = scanner.nextInt();
      switch(menu) {
        case 1:
          input();
          break;
        case 2:
          view();
          break;
        case 3:
          finish();
          return; //run을 리턴함
        default:
          System.out.println("메뉴 선택 오류");
      }
    }
  }
  
}