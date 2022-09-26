package lab4.zad7;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Colors red = Colors.getRed();
        System.out.println(red);

        Colors random = Colors.getRandomColor();
        System.out.println(random);

        System.out.println(red.compareTo(random));
        random.helloWorld();
    }

    public enum Colors{
        BLACK{
            public void helloWorld(){
                System.out.println("I'm BLACK");
            }
        }, RED{
            public void helloWorld(){
                System.out.println("I'm RED");
            }
        }, BLUE{
            public void helloWorld(){
                System.out.println("I'm BLUE");
            }
        }, GREEN{
            public void helloWorld(){
                System.out.println("I'm GREEN");
            }
        }, CYAN{
            public void helloWorld(){
                System.out.println("I'm CYAN");
            }
        }, MAGENTA{
            public void helloWorld(){
                System.out.println("I'm MAGENTA");
            }
        }, YELLOW{
            public void helloWorld(){
                System.out.println("I'm YELLOW");
            }
        }, WHITE{
            public void helloWorld(){
                System.out.println("I'm WHITE");
            }
        };

        public abstract void helloWorld();

        public static Colors getRandomColor(){
            int val = new Random().nextInt(8);
            return switch (val) {
                case 0 -> Colors.RED;
                case 1 -> Colors.BLUE;
                case 2 -> Colors.GREEN;
                case 3 -> Colors.BLACK;
                case 4 -> Colors.CYAN;
                case 5 -> Colors.MAGENTA;
                case 6 -> Colors.WHITE;
                case 7 -> Colors.YELLOW;
                default -> null;
            };
        }
        static Colors getRed() {
            return RED;
        }

        static Colors getGreen() {
            return GREEN;
        }

        static Colors getBlue() {
            return BLUE;
        }
    }
}
