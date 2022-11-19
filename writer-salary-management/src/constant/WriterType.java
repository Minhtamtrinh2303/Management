package constant;

public enum WriterType {

    CHUYEN_NGHIEP("chuyên nghiệp"),
    NGHIEP_DU("nghiệp dư"),
    CTV("cộng tác viên");

    public String value;

    WriterType(String value) {
        this.value = value;
    }
}
