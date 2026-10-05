//import kafka.Employee;
//
//import java.util.*;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//public class StreamAPI {
//    static void main() {
//
//    }
//
//    public void findEven(){
//        int arr[] =new int[]{2,4,3,1,5,7};
//        Arrays.stream(arr).filter(x->x%2==0).toArray();
//
//    }
//    public void removeDuplicate(){
//        List<Integer> list= List.of(1,2,3,4,5,8,2,1,4,4,5);
//
//        Set<Integer> set=new HashSet<>();
//        list.stream().filter(x->!set.add(x)).collect(Collectors.toSet());
//    }
//
//    public void firstNonRepetingCharacter(){
//        String s="abhwbvejehb";
//
//        s.chars().mapToObj(c->(char)c).collect(
//                Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
//                .entrySet().stream().filter(x->x.getValue()==1)
//                .map(Map.Entry::getKey)
//                .findFirst().orElse(null);
//    }
//
//    public void secoundHighestSalary(){
//
//        employees.stream().sorted(Employee::getSalary,Comparator.reverseOrder()).map(x->x.getSalary()).findFirst();
//    }
//
//    public void highestSalaryByDepertment(){
//        employees.stream().collect(collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))))
//    }
//
//    public void groupAnagram(){
//        words.stream().collect(Collectors.groupingBy(word->{
//           char[] chars=word.toCharArray();
//            Arrays.sort(chars);
//           return chars.toString();
//        }));
//    }
//}
