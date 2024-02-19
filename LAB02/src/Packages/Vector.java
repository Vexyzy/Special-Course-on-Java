package Packages;

public class Vector {
    private double[] vector;
    public Vector(int vector_length)
    {
        vector = new double[vector_length];
    }
    public double[] getVector()
    {
        return vector;
    }
    public double getElement(int index)
    {
        return vector[index];
    }
    public void setElement(int index, double value)
    {
        vector[index] = value;
    }
    public int getLength()
    {
        return vector.length;
    }
    public double[] min_and_max_values()
    {
        double min = vector[0];
        double max = vector[0];
        double[] arr = new double[2];

        for(int i = 1; i < vector.length; i++)
        {
            if(vector[i] < min)
            {
                min = vector[i];
            }
            if(vector[i] > max)
            {
                max = vector[i];
            }
        }
        arr[0] = min;
        arr[1] = max;
        return arr;
    }

    public void sort()
    {
        double support;
        for(int i = 0; i < vector.length - 1; i++)
        {
            for(int j = i+1; j < vector.length; j++)
            {
                if(vector[i] > vector[j])
                {
                    support = vector[i];
                    vector[i] = vector[j];
                    vector[j] = support;
                }
            }
        }
    }

    public double getNorm()
    {
        double norm = 0;
        for(int i=0; i < vector.length; i++)
        {
            norm += Math.pow(vector[i], 2);
        }
        return norm;
    }
    public void mulVector(double number)
    {
        for(int i = 0; i < vector.length; i++)
        {
            setElement(i, getElement(i)*number);
        }
    }

    public static Vector getSumVectors(Vector first_vector, Vector second_vector)
    {
        Vector sumVector;
        int minLength;
        if(first_vector.getLength() >= second_vector.getLength())
        {
            minLength = second_vector.getLength();
            sumVector = new Vector(first_vector.getLength());
            for(int i = 0; i < minLength; i++)
            {
                sumVector.setElement(i, first_vector.getElement(i) + second_vector.getElement(i));
            }
            for(int i = minLength; i < first_vector.getLength(); i++)
            {
                sumVector.setElement(i, first_vector.getElement(i));
            }
        }
        else
        {
            minLength = first_vector.getLength();
            sumVector = new Vector(second_vector.getLength());
            for(int i = 0; i < minLength; i++)
            {
                sumVector.setElement(i, first_vector.getElement(i) + second_vector.getElement(i));
            }
            for(int i = minLength; i < second_vector.getLength(); i++)
            {
                sumVector.setElement(i, second_vector.getElement(i));
            }
        }
        return sumVector;
    }

    public static double getMultiplyVector(Vector first_vector, Vector second_vector)
    {
        double multiplyVector = 0;
        if(first_vector.getLength() != second_vector.getLength())
        {
            return -1;
        }
        for(int i = 0; i < first_vector.getLength(); i++)
        {
            multiplyVector += first_vector.getElement(i) * second_vector.getElement(i);
        }
        return multiplyVector;
    }
}
