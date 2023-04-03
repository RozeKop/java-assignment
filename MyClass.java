import java.time.LocalDateTime;
import java.util.ArrayList;

public class MyClass
{
    private LocalDateTime time;
    private String name;
    private ArrayList<Long> numbers;
    private ArrayList<String> strings;

    public MyClass(LocalDateTime time, String name, ArrayList<Long> numbers, ArrayList<String>
            strings) {
        setTime(time);
        setName(name);
        setNumbers(numbers);
        setStrings(strings);
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        if(time != null) {
            this.time = time;
        }
        else{
            this.time = LocalDateTime.now();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null){
            this.name = "";
        }
        else{
            this.name = name;
        }

    }

    public ArrayList<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Long> numbers) {
        if (numbers == null){
            this.numbers = new ArrayList<Long>();
        }
        else{
            this.numbers = numbers;

        }
    }

    public ArrayList<String> getStrings() {
        return strings;
    }

    public void setStrings(ArrayList<String> strings) {
        if(strings == null){
            this.strings = new ArrayList<String>();
        }
        else{
            this.strings = strings;

        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyClass) {
            return name.equals(((MyClass)obj).name);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name);
        for (long num : numbers) {
            sb.append(" ").append(num);
        }
        return sb.toString();
    }

    public void removeString(String str) {
        if (str == null){
            return;
        }
        this.strings.removeIf(s -> s != null  && s.equals(str));
    }

    public boolean containsNumber(long number) {
        return numbers.contains(number);
    }

    public boolean isHistoric() {
        return time.isBefore(LocalDateTime.now());
    }
}