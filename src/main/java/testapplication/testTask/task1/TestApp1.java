package testapplication.testTask.task1;

public class TestApp1 {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.print();
        Parent child = new Child();
        child.print();
    }

    private static class Parent {
        protected String fio;

        public Parent() {
            this.fio = "анна мария оглы";
        }

        private void print() {
            System.out.println(formattingString());
        }

        protected String formattingString() {
            return fio + "!";
        }
    }

    private static class Child extends Parent {
        public Child() {
            this.fio = "АН'НА-МАРИЯ оглы";
        }

        @Override
        protected String formattingString() {
            StringBuilder result = new StringBuilder();
            String[] words = fio.toLowerCase().split("[\\s, \\-, \']");
            String[] separators = fio.replaceAll("[^\\s, \\-, \']", "").split("");
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1);
            }
            for (int i = 0; i < words.length; i++) {
                result = result.append(words[i]);
                if (i < separators.length) {
                    result.append(separators[i]);
                }
            }
            return result.toString();
        }
    }
}
//EST: 2h
