class Solution {
    public boolean backspaceCompare(String s, String t) {
        return built(s).equals(built(t));
    }

    private String built(String str) {
        StringBuilder builtStr = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                builtStr.append(c);
            } else {
                if (builtStr.length() != 0) {
                    builtStr.deleteCharAt(builtStr.length() - 1);
                }
            }
        }
        return builtStr.toString();
    }
}
