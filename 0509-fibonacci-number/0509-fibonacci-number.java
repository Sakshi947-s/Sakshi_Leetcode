class Solution {
    int [] memo;

    public int f(int n) {
        if(n <= 1)
           return n;

        if(memo[n] != 0)
           return memo[n];

        return memo[n] = f(n -1 ) + f(n - 2);
    }

    public int fib(int n) {
        memo = new int[n + 1];
        return f(n);
    }
}