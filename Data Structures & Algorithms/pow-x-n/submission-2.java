class Solution {
    public double myPow(double x, int n) {
        // Recursive Solution 
        if(n < 0) return 1/pow(x, n);
        return pow(x,n);
    }

    private double pow(double x, int n){
        if(n == 0) return 1.0;
        else if(n == 1) return x;
        else if(n % 2 == 0) return pow(x*x, n/2);
        else return x * pow(x*x, n/2);
    }
}
