import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private Scanner scanner;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        //Ex 2 Remove Objects
//        removeObjectsEx();
        //Ex 3 Contains Employee
//        containsEmployeeEx();
        //Ex 4 Employee With Salary Over 50000
//        employeeWithSalaryOver5000Ex();
        //Ex 5 Employees From Department
//        employeesFromDepartmentEx();
        //Ex 6 Adding a New Address And Updating Employee
//        addingNewAddressToEmployeeEx();
        //Ex 7 Addresses with employee count
//            addressesWithEmployeeCountEx();
        //Ex 8 Get Employee With Project
//            getEmployeeWithProjectEx();
        //Ex 9 Find Latest 10 Projects
//        findLatest10Project();
        //Ex 10 Increase Salaries
//        increaseSalaries();
        //Ex 11 Remove Towns
//            removeTownsEx();
        //Ex 12 Find Employees By First Name
//            findEmployeesByFirstNameEx();
        //Ex 13 Employees Maximum Salaries
            employeesMaximumSalariesEx();

    }

    private void employeesMaximumSalariesEx() {
        entityManager.createQuery("SELECT e.department.name,MAX(e.salary) " +
                "FROM Employee AS e " +
                "WHERE e.salary NOT BETWEEN 30000 AND 70000 GROUP BY e.department.name", Object[].class)
                .getResultList().forEach(e-> System.out.printf("%s %.2f%n",e[0],e[1]));
    }

    private void findEmployeesByFirstNameEx() {
        System.out.println("Please enter pattern for first name:");
        String pattern = scanner.nextLine();
        entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.firstName LIKE :name", Employee.class)
                .setParameter("name",pattern+"%")
                .getResultList()
                .forEach(e-> System.out.printf("%s %s - %s - ($%.2f)%n",e.getFirstName(),e.getLastName(),e.getJobTitle(),e.getSalary()));
    }

    private void removeTownsEx() {
        System.out.println("Please enter town for remove");
        String townForRemove = scanner.nextLine();
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.address.town.name= :name",Employee.class)
                .setParameter("name", townForRemove)
                .getResultList();
        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address AS a WHERE a.town.name = :name",Address.class)
                .setParameter("name",townForRemove)
                .getResultList();
        Town town = entityManager.createQuery("SELECT t FROM Town AS t WHERE t.name = :name",Town.class)
                .setParameter("name",townForRemove)
                .getSingleResult();
        int numberOfAddresses = addresses.size();

        entityManager.getTransaction().begin();
        employees.forEach(e->e.setAddress(null));
        addresses.forEach(entityManager::remove);
        entityManager.remove(town);
        entityManager.getTransaction().commit();
        if(numberOfAddresses == 1){
            System.out.printf("%d address in %s deleted",numberOfAddresses,townForRemove);
        }else {
            System.out.printf("%d addresses in %s deleted",numberOfAddresses,townForRemove);
        }
    }

    private void increaseSalaries() {
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.department.name  IN('Engineering','Tool Design','Marketing','Information Services')", Employee.class)
                .getResultList();
        entityManager.getTransaction().begin();
        employees.forEach(entityManager::detach);
        employees.forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));
        employees.forEach(entityManager::merge);
        entityManager.getTransaction().commit();
        employees.forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));

    }

    private void findLatest10Project() {
        entityManager.createQuery("SELECT p FROM Project AS p ORDER BY p.startDate DESC ", Project.class)
                .getResultList()
                .stream()
                .limit(10)
                .forEach(p -> System.out.printf("Project name: %s" +
                                "%n\tProject Description: %s" +
                                "%n\tProject Start Date: %s" +
                                "%n\tProject End Date: %s%n"
                        , p.getName(), p.getDescription(), p.getStartDate(), p.getEndDate()));
    }

    private void getEmployeeWithProjectEx() {
        System.out.println("Please enter ID");
        int id = Integer.parseInt(scanner.nextLine());
        Employee employee = entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.id = :id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        employee.getProjects().stream().sorted(Comparator.comparing(Project::getName)).forEach(p -> System.out.println("\t" + p.getName()));
    }


    private void addressesWithEmployeeCountEx() {
        entityManager.createQuery("SELECT a FROM Address AS a ORDER BY a.employees.size DESC ", Address.class)
                .getResultList().stream()
                .limit(10)
                .forEach(a -> System.out.printf("%s, %s - %d employees%n", a.getText(), a.getTown().getName(), a.getEmployees().size()));

    }

    private void addingNewAddressToEmployeeEx() {
        System.out.println("Please enter employee's last name:");
        String input = scanner.nextLine();
        Employee employee = entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.lastName = :name", Employee.class)
                .setParameter("name", input)
                .getSingleResult();
        Address address = createNewAddress("Vitoshka 15");
        entityManager.getTransaction().begin();
        entityManager.detach(employee);
        employee.setAddress(address);
        entityManager.merge(employee);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    private Address createNewAddress(String addressName) {
        Address address = new Address();
        address.setText(addressName);
        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private void employeesFromDepartmentEx() {
        entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.department.name = 'Research and Development' ORDER BY e.salary,e.id", Employee.class)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s from %s - %.2f%n", e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
    }

    private void employeeWithSalaryOver5000Ex() {
        System.out.println("Ex 4");
        entityManager.createQuery("select e FROM Employee  AS e where e.salary > 50000", Employee.class)
                .getResultList()
                .forEach(e -> System.out.println(e.getFirstName()));
    }

    private void containsEmployeeEx() {
        System.out.println("Ex 2: Enter full name of employee: ");
        String employeeName = scanner.nextLine();
        try {
            Employee employee = entityManager.createQuery("SELECT e FROM Employee AS e WHERE " +
                    "CONCAT(e.firstName, ' ', e.lastName) = :name ", Employee.class).setParameter("name", employeeName).getSingleResult();
            System.out.println("Yes");
        } catch (NoResultException nre) {
            System.out.println("No");
        }
    }

    private void removeObjectsEx() {
        List<Town> towns = entityManager.createQuery("SELECT t FROM Town as t WHERE length(t.name) > 5 ", Town.class).getResultList();
        this.entityManager.getTransaction().begin();
        towns.forEach(entityManager::detach);
        List<Town> townsList = entityManager.createQuery("SELECT t FROM Town as t", Town.class).getResultList();
        townsList.forEach(town -> town.setName(town.getName().toLowerCase()));
        towns.forEach(entityManager::merge);
        this.entityManager.flush();
        this.entityManager.getTransaction().commit();
    }
}
