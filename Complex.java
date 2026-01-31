public class Complex {

    private final double re;
    private final double im;

    public Complex(double real, double imaginary) {

        re = real;
        im = imaginary;
    }

    // extract real part
    public double real() {
        return re;
    }

    // extract imaginary part
    public double imaginary() {
        return im;
    }

    // Magnitude
    public double magnitude() {
        
        return Math.sqrt(re*re + im*im);
    }

    // Conjugate pair of a Complex a
    public Complex conjugate() {

        return new Complex(re,-im);
    }

    // Sum of two Complex (Complex a + Complex  b)
    public Complex sum(Complex b) {

        double real = re + b.re;
        double imaginary = im + b.im;

        return new Complex(real,imaginary);

    }

    
    // Product of two Complex (Complex a X Complex b)
    public Complex product(Complex b) {

        double real = re*b.re - im*b.im;
        double imaginary = re*b.im + im*b.re;

        return new Complex(real, imaginary);
    }

    // power of a complex number z^t
    public Complex complexPow(int t) {

        Complex z = new Complex(re,im); 

        if (t == 0) return new Complex(1,0);
        
        for (int i = 0; i < t - 1; i++) {

            z = z.product(this);

        }

        return z;
    }

    // scalar product with a real factor
    public Complex scalar(double factor) {

        return new Complex(factor*re,factor*im);

    }

    // Quotient of two Complex (Complex a / Complex b)
    public Complex quotient(Complex b) {

        double factor =1.0/(b.re*b.re - b.im*b.im);

        return product(b.conjugate()).scalar(factor);
    }


    public String toString() {

        if (re == 0) return im + "i";
        if (im == 0) return re + "";

        else if (im < 0 ) return re + " - " + Math.abs(im) + "i";
        else return re + " + " +im + "i";
    }


    public static void main(String[] args) {

        Complex a = new Complex(1,1);
        Complex b = new Complex (1,2);

        System.out.println(a);
        System.out.println(b.conjugate());
        System.out.println(a.sum(b));
        System.out.println(a.product(b));
        System.out.println(a.magnitude());
        System.out.println(a.quotient(b));
        System.out.println(a.complexPow(2));
        

        
    }

    
}
