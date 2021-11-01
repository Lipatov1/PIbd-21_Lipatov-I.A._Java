public enum NumberGuns {
    one,
    two,
    three;

    public static NumberGuns getNumber(int number) {
        switch (number) {
            case 0:
                return NumberGuns.one;
            case 1:
                return NumberGuns.two;
            case 2:
                return NumberGuns.three;
            default:
                return NumberGuns.one;
        }
    }
}