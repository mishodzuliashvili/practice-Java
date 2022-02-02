package StringClass;

public class MyString {
    private char value;
    private MyString next;
    public MyString(){}
    private MyString(char value, MyString next) {
        this.value = value;
        this.next = next;
    }

    public void add(char[] x){
        for (char c : x) {
            next = new MyString(value, next);
            value = c;
        }
    }
    public char charAt(int x){
        if (x < 0 || length() <= x) throw new RuntimeException("its out of bound");
        x = this.length() - x - 1;
        var res = this;
        while (x > 0){
            res = res.next;
            x--;
        }
        return res.value;
    }

    public int length() {
        if (value == Character.MIN_VALUE)
        return 0;
        int result = 0;
        for (var res = this; res.next != null; res = res.next){
            result++;
        }
        return result;
    }

    @Override
    public String toString() {
        if (value == Character.MIN_VALUE) return "";
        return next + "" + value;
    }
}
