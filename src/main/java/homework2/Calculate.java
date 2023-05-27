package homework2;

public class Calculate {

    public double[] calculateMinimums(double[] array){

        double min1;
        double min2;
        double[] output_array = new double[2];

        if(array == null || array.length == 0 || array.length == 1) {

            throw new IllegalArgumentException("the array can't be null, empty or equals to 1");

        }

        if(array[0]<array[1]){

            min1 = array[0];
            min2 = array[1];

        }
        else {

            min1 = array[1];
            min2 = array[0];

        }
        for(int i = 2; i<array.length; i++) {

            if(array[i]> min1 && array[i] > min2)
                continue;

            if(array[i]< min1) {

                min2=min1;
                min1=array[i];

            }
            else {

                min2=array[i];

            }

        }

        output_array[0] = min1;
        output_array[1] = min2;

        return output_array;

    }

}
