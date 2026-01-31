import java.awt.Color;

public class NewtonChaos {

    // Strategy: Argand Diagram

    public static Color Newton(Complex z0, double tol){

        Complex z = new Complex(0, 0);

        boolean converge = false;


        for (int i = 0; i < 100; i++) {

            Complex numerical = z0.complexPow(4).sum(new Complex(- 1,0));

            Complex denominator = z0.complexPow(3).scalar(4.0);

            z = numerical.quotient(denominator).scalar(-1).sum(z0);

            double diffRe = Math.abs(z.real() - z0.real());

            double diffIm = Math.abs(z.imaginary() - z0.imaginary());

            z0 = z;

            if ((diffRe < tol && diffIm < tol)) {

                converge = true;
                break;
            }
        }

        if (converge) {

            if (Math.round(z.real()) == 1) return new Color (0,0,0);
            if (Math.round(z.real()) == -1) return new Color (255,0,0);
            if (Math.round(z.imaginary()) == 1) return new Color (0,255,0);
            if (Math.round(z.imaginary()) == -1) return new Color (0,0,255);
            else return new Color(128,128,128);
        }

        else return new Color(255,255,255);
    }

    public static void main(String[] args) {

        int n = 800;

        double size = 2.0;

        double tol = 1e-6;

        Picture convergence = new Picture(n,n);

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < n; col++) {

                // rescaling relative to origin

                double real = col*size/n - size/2;

                double imaginary = row*size/n - size/2;

                Color pixel = Newton(new Complex(real, imaginary), tol);

                convergence.set(col, n - 1 - row, pixel);

            }
        }

        convergence.show();

    }
    
}
