package sgu.hrm.module_soyeulylich;

import jakarta.persistence.Column;

public class Okss {
    @Column
    private String dfdfdf;

    public String getOkk() {
        return okk;
    }

    public void setOkk(String okk) {
        this.okk = okk;
    }

    private String okk;

    public String getDfdfdf() {
        return dfdfdf;
    }

    public void setDfdfdf(String dfdfdf) {
        this.dfdfdf = dfdfdf;
    }

    public Okss() {
        this.dfdfdf = "wow";
        this.okk = "okey";
    }

    public Okss(String dfdfdf) {
        this.dfdfdf = dfdfdf;
    }
}
