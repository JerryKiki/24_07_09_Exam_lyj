package org.koreait;

public class Rq {
    private String actionMethod = "";
    private int idx = 0;

    public Rq(String cmd) {
        String[] cmdBits = cmd.split("\\?");
        this.actionMethod = cmdBits[0];
        if (cmdBits.length == 2) {
            String[] idxBits = cmdBits[1].split("=");
            if (idxBits.length > 1) {
                try {
                    this.idx = Integer.parseInt(idxBits[1]);
                } catch (NumberFormatException e) {
                    //System.out.println("id는 숫자로 입력해주세요.");
                }
            }
        }
    }

    public String getActionMethod() {
        return actionMethod;
    }

    public int getIdx() {
        return idx;
    }
}
