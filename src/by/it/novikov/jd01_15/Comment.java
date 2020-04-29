package by.it.novikov.jd01_15;

enum Comment {

    SINGLE_lINE_COMMENT {
        void deleteComment(StringBuilder textBuilder, int i) {
            while (textBuilder.charAt(i + 2) != '\n') {
                textBuilder.deleteCharAt(i + 2);
            }
            textBuilder.delete(i, i + 2);
        }
    },
    MULTIPLE_LINE_COMMENT {
        void deleteComment(StringBuilder textBuilder, int i) {
            while (!(textBuilder.charAt(i + 2) == '*' && textBuilder.charAt(i + 3) == '/')) {
                textBuilder.deleteCharAt(i + 2);
            }
            textBuilder.delete(i, i + 4);
        }
    };

    void deleteComment(StringBuilder textBuilder, int i) {

    }
}