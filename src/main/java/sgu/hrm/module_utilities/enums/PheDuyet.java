package sgu.hrm.module_utilities.enums;

public enum PheDuyet {
    CHUA_PHE_DUYET(0, "CHƯA PHÊ DUYỆT"),
    CHO_PHE_DUYET(1, "CHỜ PHÊ DUYỆT"),
    DA_PHE_DUYET(2, "ĐÃ PHÊ DUYỆT"),
    ;
    private int id;
    private String name;

    PheDuyet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
