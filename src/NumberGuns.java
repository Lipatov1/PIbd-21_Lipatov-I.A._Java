public enum NumberGuns {
    one,
    two,
    three;

    public static NumberGuns getNumber(int number) {
        switch (number) {
            case 1:
                return NumberGuns.one;
            case 2:
                return NumberGuns.two;
            case 3:
                return NumberGuns.three;
        }
        return null;
    }
}