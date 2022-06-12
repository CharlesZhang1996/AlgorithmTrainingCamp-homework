class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> m = new HashMap<String, Integer> ();
        for (String str : cpdomains) {
            String[] cpInfo = str.split(" ");
            Integer cnt = Integer.valueOf(cpInfo[0]);
            String[] subDomains = cpInfo[1].split("\\.");
            String trueDomain = "";
            int n = subDomains.length;
            for (int i = n-1; i >=0; i--) {
                if (i == n-1) {
                    trueDomain += subDomains[i];
                } else {
                    trueDomain = subDomains[i] + "." + trueDomain;
                }
                m.put(trueDomain, m.getOrDefault(trueDomain, 0) + cnt);
            }
        }
        ArrayList<String> ans = new ArrayList<String>();
        for (Map.Entry<String, Integer> e : m.entrySet()) {
            String b = e.getKey();
            Integer count = e.getValue();
            String ansStr = "" + count + " " + b;
            ans.add(ansStr);
        }
        return ans;
    }
}