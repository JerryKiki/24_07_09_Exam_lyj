package org.koreait.motivation.controller;

import org.koreait.Container;
import org.koreait.Util;
import org.koreait.motivation.entity.Motivation;

import java.util.HashMap;

public class MotivationController {
    int lastId;
    HashMap<Integer, Motivation> motivations;

    public MotivationController() {
        lastId = 0;
        motivations = new HashMap<>();
    }

    public void doWrite() {
        int id = lastId + 1;
        String regDate = Util.getNow();
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine();
        System.out.print("작가 : ");
        String author = Container.getSc().nextLine();
        motivations.put(id, new Motivation(id, regDate, content, author));
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        lastId++;
    }

    public void showList() {
        System.out.println("번호  /  작가  /  명언  ");
        System.out.println("=============================");
        for (int i = lastId; i > 0; i--) {
            if (motivations.containsKey(i)) {
                Motivation motivation = motivations.get(i);
                System.out.printf("%d  /  %s  /  %s  \n",
                        motivation.getId(), motivation.getAuthor(), motivation.getContent());
            }
        }
    }

    public void doUpdate(int idx) {
        if (!motivations.containsKey(idx)) System.out.printf("%d번 명언은 존재하지 않습니다.\n", idx);
        else {
            Motivation motivation = motivations.get(idx);
            System.out.println("명언(기존) :" + motivation.getContent());
            System.out.println("작가(기존) :" + motivation.getAuthor());
            System.out.print("명언 : ");
            String newContent = Container.getSc().nextLine();
            System.out.print("작가 : ");
            String newAuthor = Container.getSc().nextLine();
            motivation.setContent(newContent);
            motivation.setAuthor(newAuthor);
            System.out.printf("%d번 명언이 수정되었습니다.\n", idx);
        }
    }

    public void showDetail(int idx) {
        if (!motivations.containsKey(idx)) System.out.printf("%d번 명언은 존재하지 않습니다.\n", idx);
        else {
            Motivation motivation = motivations.get(idx);
            System.out.println("번호 : " + motivation.getId());
            System.out.println("날짜 : " + motivation.getRegDate());
            System.out.println("작가 : " + motivation.getAuthor());
            System.out.println("내용 : " + motivation.getContent());
        }
    }

    public void doDelete(int idx) {
        if (!motivations.containsKey(idx)) System.out.printf("%d번 명언은 존재하지 않습니다.\n", idx);
        else {
            motivations.remove(idx);
            System.out.printf("%d번 명언이 삭제되었습니다.\n", idx);
        }
    }
}
