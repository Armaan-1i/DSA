class Solution {
    int cross(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1])
             - (b[1] - a[1]) * (c[0] - a[0]);
    }
    public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 1) {
            return trees;
        }
        Arrays.sort(trees, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        List<int[]> lower = new ArrayList<>();
        for (int[] point : trees) {
            while (lower.size() >= 2 &&
                   cross(lower.get(lower.size() - 2),
                         lower.get(lower.size() - 1),
                         point) < 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(point);
        }
        List<int[]> upper = new ArrayList<>();
        for (int i = trees.length - 1; i >= 0; i--) {
            int[] point = trees[i];
            while (upper.size() >= 2 &&
                   cross(upper.get(upper.size() - 2),
                         upper.get(upper.size() - 1),
                         point) < 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(point);
        }
        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);
        lower.addAll(upper);
        Set<String> set = new HashSet<>();
        List<int[]> ans = new ArrayList<>();
        for (int[] p : lower) {
            String key = p[0] + "," + p[1];
            if (!set.contains(key)) {
                set.add(key);
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}