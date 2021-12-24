import java.util.Comparator;

public class MilitaryEquipmentComparer implements Comparator<Vehicle> {
    @Override
    public int compare(Vehicle x, Vehicle y) {
        if (!x.getClass().getSimpleName().equals(y.getClass().getSimpleName())) {
            return x.getClass().getSimpleName().compareTo(y.getClass().getSimpleName());
        }
        int result;
        switch (x.getClass().getSimpleName()) {
            case "ArmoredCar" -> {
                result = comparerArmoredCar((ArmoredCar) x, (ArmoredCar) y);
                return result;
            }
            case "SelfPropArtilleryInstal" -> {
                result = comparerSelfPropArtilleryInstal((SelfPropArtilleryInstal) x, (SelfPropArtilleryInstal) y);
                return result;
            }
        }
        return 100;
    }

    private int comparerArmoredCar(ArmoredCar x, ArmoredCar y) {
        if (x.getMaxSpeed() != y.getMaxSpeed()) {
            return Integer.compare(x.getMaxSpeed(), y.getMaxSpeed());
        }
        if (x.getWeight() != y.getWeight()) {
            return Float.compare(x.getWeight(), y.getWeight());
        }
        if (x.getMainColor() != y.getMainColor()) {
            return Integer.compare(x.getMainColor().getRGB(), y.getMainColor().getRGB());
        }
        return 0;
    }

    private int comparerSelfPropArtilleryInstal(SelfPropArtilleryInstal x, SelfPropArtilleryInstal y) {
        int result = comparerArmoredCar(x, y);
        if (result == 0) {
            return result;
        }

        if (x.getDopColor() != y.getDopColor()) {
            return Integer.compare(x.getDopColor().getRGB(), y.getDopColor().getRGB());
        }
        if (x.isCamouflage() != y.isCamouflage()) {
            return Boolean.compare(x.isCamouflage(), y.isCamouflage());
        }
        if (x.isStar() != y.isStar()) {
            return Boolean.compare(x.isStar(), y.isStar());
        }
        if (x.isCaterpillar() != y.isCaterpillar()) {
            return Boolean.compare(x.isCaterpillar(), y.isCaterpillar());
        }
        if (x.getAdditionalElems() != null && y.getAdditionalElems() != null
                && !(x.getAdditionalElems().toString().equals(y.getAdditionalElems().toString()))) {
            return x.getAdditionalElems().toString().compareTo(y.getAdditionalElems().toString());
        }
        if (x.getAdditionalElems() == null && y.getAdditionalElems() != null) {
            return 1;
        }
        if (x.getAdditionalElems() != null && y.getAdditionalElems() == null) {
            return -1;
        }
        return 0;
    }
}