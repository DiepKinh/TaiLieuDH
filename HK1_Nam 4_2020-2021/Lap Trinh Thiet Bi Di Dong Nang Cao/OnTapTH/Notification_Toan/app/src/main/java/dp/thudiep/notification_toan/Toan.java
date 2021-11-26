package dp.thudiep.notification_toan;

import java.io.Serializable;

public class Toan implements Serializable {
    private String tv_A;
    private String tv_B;
    private String tv_KQ;
    private String tv_PT;

    public Toan(String tv_A, String tv_B, String tv_KQ, String tv_PT) {
        this.tv_A = tv_A;
        this.tv_B = tv_B;
        this.tv_KQ = tv_KQ;
        this.tv_PT = tv_PT;
    }

    public String getTv_A() {
        return tv_A;
    }

    public void setTv_A(String tv_A) {
        this.tv_A = tv_A;
    }

    public String getTv_B() {
        return tv_B;
    }

    public void setTv_B(String tv_B) {
        this.tv_B = tv_B;
    }

    public String getTv_KQ() {
        return tv_KQ;
    }

    public void setTv_KQ(String tv_KQ) {
        this.tv_KQ = tv_KQ;
    }

    public String getTv_PT() {
        return tv_PT;
    }

    public void setTv_PT(String tv_PT) {
        this.tv_PT = tv_PT;
    }
}
