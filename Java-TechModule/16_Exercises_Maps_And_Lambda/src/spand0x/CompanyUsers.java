package spand0x;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<String>> companyUsers = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split(" -> ");
        while(!"End".equalsIgnoreCase(input[0])){
            String company = input[0];
            String employee = input[1];
            if(companyUsers.containsKey(company)){
                if(!companyUsers.get(company).contains(employee)){
                    companyUsers.get(company).add(employee);
                }
            }else {
                companyUsers.put(company,new ArrayList<>());
                companyUsers.get(company).add(employee);
            }
            input = scanner.nextLine().split(" -> ");
        }
        companyUsers.entrySet().stream().sorted((e1,e2)->e1.getKey().compareTo(e2.getKey())).forEach(e1->{
            System.out.println(e1.getKey());
            e1.getValue().stream().forEach(e-> System.out.println("-- "+e));
        });
    }
}
