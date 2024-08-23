package j17.text_blocks;

public class TextBlocksTest {
        public static void textBlocks() {
            // 1. A text block is a String object (immutable and interned)
//            String sName  = "Sean Kennedy";
//            String tbName = """
//                Sean Kennedy"""; // no newline embedded at end
//            System.out.println(sName.equals(tbName));   // true
//            System.out.println(sName == tbName);        // true
//
//            // 2. String methods can be applied to text blocks
//            System.out.println(tbName.substring(5));    // Kennedy

            // 3. Text blocks start with """ followed by a line terminator
//        String tb1 = """abc""";
//        String tb2 = """abc
//                """;
//            String tb3 = """
//                abc
//                """;
//            System.out.println(tb3);        //  abc

            // 4. Embedded double quotes are not required in text blocks
//            String sQuote = "Hamlet: \"There is nothing either good or bad, " +
//                    "but thinking makes it so\""; // on one line
//            System.out.println(sQuote);
//            String tbQuote = """
//                Hamlet: "There is nothing either good or bad, but thinking makes it so"
//                """;
//            System.out.println(tbQuote); // on one line

            // 5. Depending on where you place the closing delimiter, determines whether or not you have a closing “\n”.
            String sBookTitle1  = "Java\nMemory\nManagement\n"; // newline at end
            String tbBookTitle1 = """
                Java
                Memory
                Management
                """;    // same as "Java\nMemory\nManagement\n"; // newline at end
            System.out.println(sBookTitle1);
            System.out.println(123);
            System.out.println(tbBookTitle1);
            System.out.println(123);

            String sBookTitle2  = "Java\nMemory\nManagement"; // NO newline at end
            String tbBookTitle2 = """
                Java
                Memory
                Management""";  // same as "Java\nMemory\nManagement"; // NO newline at end
            System.out.println(sBookTitle2);
            System.out.println(123);
            System.out.println(tbBookTitle2);
            System.out.println(123);

        }

        public static void main(String[] args) {
//            textBlocks();
//            jsonTraditionalStyle();
            jsonTextBlock();
    }
    public static void jsonTraditionalStyle() {
        String text = "{\n" +
                "  \"name\": \"Jane Doe\",\n" +
                "  \"age\": 23,\n" +
                "  \"address\": \"Main Street, Dublin\"\n" +
                "}";
        System.out.println(text);
    }
    public static void jsonTextBlock() {
        String text = """
            {
              "name": "Jane Doe",
              "age": 23,
              "address": "Main Street, Dublin"
            }
          """;
        // to remove incidental spaces, put delimiter on its own line
        System.out.println(text);
        System.out.println(1234);
    }
}
