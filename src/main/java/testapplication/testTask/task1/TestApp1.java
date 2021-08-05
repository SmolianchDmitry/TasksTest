package testapplication.testTask.task1;

import java.util.Arrays;
import java.util.stream.Collectors;

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
            String[] words = fio.toLowerCase().split("(?<=[\'\\s\\-])");
            return Arrays.stream(words)
                    .map(string -> string.substring(0,1).toUpperCase() + string.substring(1))
                    .collect(Collectors.joining());
        }
    }
}
//EST: 3h
