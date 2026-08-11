class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {

            // Find how many words can fit in this line
            int j = i;
            int totalChars = 0;

            while (j < n) {
                int newLength = totalChars + words[j].length();

                // Add one space between words
                if (j > i) {
                    newLength += (j - i);
                }

                if (newLength > maxWidth) {
                    break;
                }

                totalChars += words[j].length();
                j++;
            }

            int wordCount = j - i;
            int spaces = maxWidth - totalChars;

            StringBuilder line = new StringBuilder();

            // Last line OR only one word
            if (j == n || wordCount == 1) {

                for (int k = i; k < j; k++) {
                    if (k > i) {
                        line.append(" ");
                    }

                    line.append(words[k]);
                }

                // Add remaining spaces at the end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                // Fully justified line
                int gaps = wordCount - 1;

                int spacesPerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j; k++) {

                    line.append(words[k]);

                    if (k < j - 1) {

                        int currentSpaces = spacesPerGap;

                        // Extra spaces go to left gaps
                        if (k - i < extraSpaces) {
                            currentSpaces++;
                        }

                        for (int s = 0; s < currentSpaces; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());

            // Move to next line
            i = j;
        }

        return result;
    }
}