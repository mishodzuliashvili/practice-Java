package StringClass;

public class Main {
    public static void main(String[] args) {
        MyString str = new MyString();
        str.add(new char[]{'h','e','l','l','o',' ','w','o','r','l','d'});
        System.out.println(str);
        System.out.println(str.charAt(11));
        System.out.println(str.length());
    }
}
