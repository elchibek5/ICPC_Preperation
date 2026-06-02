class Solution {
    public String generateTag(String caption) {

        if (caption == null) return "";

        StringBuilder result = new StringBuilder();
        result.append('#');
        String[] words = caption.trim().split("\\s+");

        
        for (String word : words) {
            if (!word.isEmpty()) {
                if (result.length() == 1) {
                    result.append(Character.toLowerCase(word.charAt(0)));
                } else {
                    result.append(Character.toUpperCase(word.charAt(0)));
                }

                result.append(word.substring(1).toLowerCase());
            }
        }

        return result.substring(0, Math.min(result.length(), 100));
    }
}
