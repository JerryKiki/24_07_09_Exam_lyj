package org.koreait;

import org.koreait.motivation.controller.MotivationController;

public class App {

    static int system_status = 0;

    public void run() {
        System.out.println("== 명언 앱 실행 ==");

        system_status = 1;
        MotivationController motivationController = new MotivationController();

        while (system_status == 1) {
            System.out.print("명령어 ) ");
            String cmd = Container.getSc().nextLine();

            Rq rq = new Rq(cmd);
            String actionMethod = rq.getActionMethod();
            int idx = rq.getIdx();

            switch (actionMethod) {
                case "등록" :
                    motivationController.doWrite();
                    break;
                case "목록" :
                    motivationController.showList();
                    break;
                case "수정" :
                    motivationController.doUpdate(idx);
                    break;
                case "상세보기" :
                    motivationController.showDetail(idx);
                    break;
                case "삭제" :
                    motivationController.doDelete(idx);
                    break;
                case "나가기" :
                    System.out.println("== 명언 앱 종료 ==");
                    system_status = 0;
                    break;
                default :
                    System.out.println("올바른 명령어를 입력해주세요.");
            }
        }
    }
}
