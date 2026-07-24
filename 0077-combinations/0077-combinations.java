class Solution {
    public List<List<Integer>> f(int inx , int n) {
        if(inx > n) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());
            return ans;
        }

        List<List<Integer>> ans = f(inx + 1 , n);

        int sz = ans.size();

        for(int i = 0; i < sz; ++i) {
            ArrayList<Integer> t = new ArrayList<>();
            t.add(inx);

            for(int j = 0; j < ans.get(i).size(); ++j)
               t.add(ans.get(i).get(j));

            ans.add(t);
        }

        return ans;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> t = f(1 , n);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < t.size(); ++i)
            if(t.get(i).size() == k)
                ans.add(t.get(i));

        return ans;
    }
}