public class LucasSeries {
    protected int[] series;
    protected int size = 0;

    LucasSeries (int n) {
        if (n == 0) {
            series = new int[1];
            size = 0;
        } else {
            series = new int[n];
            size = n;
        }
    }

    int[] getSeries () {
        return series;
    }

    int getSize () {
        return size;
    }

    public int getResult () {
        if (size == 0) {
            return 0;
        }

        return series[size-1];
    }

    public void calculateLucasSeries () {
        series[0] = 2;

        if (size > 1) {
            series[1] = 1;
            for (int counter = 2; counter < size; counter++) {
                series[counter] = series[counter - 2] + series[counter - 1];
            }
        }
    }
}
