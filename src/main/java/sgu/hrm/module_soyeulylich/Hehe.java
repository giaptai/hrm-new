package sgu.hrm.module_soyeulylich;

public class Hehe {
    Okss okss;

    public Hehe() {
    }

    public Hehe(Okss okss) {
        this.okss = okss;
    }

    @Override
    public String toString() {
        return "Hehe{" +
                "okss Dfdfdf=" + okss.getDfdfdf() +
                "okss getOkk=" + okss.getOkk() +
                '}';
    }

    public static void main(String[] args) {
        Hehe hehe = new Hehe(new Okss());
        System.out.println(hehe);
    }
}
