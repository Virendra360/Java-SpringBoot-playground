package core.practise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonToObject {


    public static void main(String[] args) throws IOException {

        Employee emp1= new Employee(24435,"John",26);
        Employee emp2= new Employee(24478,"Steve",24);

        List<Employee> empList= List.of(emp1,emp2);

        /**
         * Java does not have any library for JSON to Object operations, which is part of standard libraries
         * AAlternative is Using external libraries like
         * 1. Jackson library
         */

        // Create an ObjectMapper
//        ObjectMapper objectMapper = new ObjectMapper();

//        // Serialize the User object to JSON (no annotations involved)
//        String jsonString = objectMapper.writeValueAsString(emp1);
//        String jsonString2= objectMapper.writeValueAsString(empList);
//
//        System.out.println(jsonString);
//        System.out.println(jsonString2);

        /**
         * we can convert to json and write in file also
         */
//        String basePath= System.getProperty("user.dir") ;
//        objectMapper.writeValue(new File(basePath+"/data.json"),empList);

//        [{"empId":24434,"name":"John","age":26},{"empId":24478,"name":"Steve","age":24}]

//        Employee e1=  objectMapper.readValue(jsonString, Employee.class);
//        System.out.println("emp name :"+e1.getName()+" , "+"emp age :"+e1.getAge());
//        System.out.println(e1);

        // reading from file
//        List<Employee> list=  objectMapper.readValue(new File(basePath+"/data.json"), new TypeReference<List<Employee>>() {});

//        List<Employee> list=  objectMapper.readValue(jsonString2, new TypeReference<List<Employee>>() {});
//
//        System.out.println("-------------***********---------------");
//        System.out.println(list);
//        list.forEach(i->{
//
//            System.out.println("emp name :"+i.getName()+" , "+"emp age :"+i.getAge());
//            System.out.println(i);
//        });

        /**
         * Using external libraries
         * 2. gson library
         */

//        Gson gson=new Gson();
//
//       String jsonString= gson.toJson(emp1);
//       String jsonString2=gson.toJson(empList);
//
//        System.out.println("-------------***********---------------");
//
//        System.out.println(jsonString2);
//        System.out.println(jsonString);
//
//        System.out.println("-------------***********---------------");

        /**
         * for writing in file we need FileWriter in gson
         * Note : fileWriter should be closed properly or data will not be flushed
         */

//        String basePath= System.getProperty("user.dir") ;
//
//        FileWriter fileWriter = new FileWriter(basePath + "/data.json");
//        gson.toJson(empList,fileWriter);
//        fileWriter.close();

        /**
         *  use try with resource which closes resource automatically
         */
//        try (FileWriter fileWriter = new FileWriter(basePath + "/data.json")) {
//            gson.toJson(empList, fileWriter);
//            System.out.println("Data written to file successfully");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Employee e1= gson.fromJson(jsonString, Employee.class);
//
//        System.out.println("emp name :"+e1.getName()+" , "+"emp age :"+e1.getAge());
//        System.out.println(e1);
//
//        System.out.println("-------------***********---------------");

        /**
         * List.class will not work, we need to pass Type or TypeToken
         */
//        List<Employee> list =gson.fromJson(jsonString2,List.class);

        // Define the type for the List<Employee>
//        Type employeeListType = new TypeToken<List<Employee>>() {}.getType();

//        List<Employee> list =gson.fromJson(jsonString2,new TypeToken<List<Employee>>(){});

        /**
         * TO read from need FileReader
         */
//        List<Employee> list =gson.fromJson(new FileReader(basePath+"/data.json"),new TypeToken<List<Employee>>(){});
//
//
//        list.forEach(i->{
//
//            System.out.println("emp name :"+i.getName()+" , "+"emp age :"+i.getAge());
//            System.out.println(i);
//        });
//
//        System.out.println(list);
//        System.out.println("-------------***********---------------");

        /**
         * Below is example JSON-java
         * which is also part of external library
         * Add org.json dependency to use below code
         */

        String jsonStringArray= "[{\"id\":1,\"name\":\"USER-1\",\"email\":\"user1@gmail.com\",\"password\":\"USER-1@77\"},{\"id\":2,\"name\":\"USER-2\",\"email\":\"user2@gmail.com\",\"password\":\"USER-2@77\"},{\"id\":3,\"name\":\"USER-3\",\"email\":\"user3@gmail.com\",\"password\":\"USER-3@77\"},{\"id\":4,\"name\":\"USER-4\",\"email\":\"user4@gmail.com\",\"password\":\"USER-4@77\"},{\"id\":5,\"name\":\"USER-5\",\"email\":\"user5@gmail.com\",\"password\":\"USER-5@77\"},{\"id\":6,\"name\":\"USER-6\",\"email\":\"user6@gmail.com\",\"password\":\"USER-6@77\"},{\"id\":7,\"name\":\"USER-7\",\"email\":\"user7@gmail.com\",\"password\":\"USER-7@77\"},{\"id\":8,\"name\":\"USER-8\",\"email\":\"user8@gmail.com\",\"password\":\"USER-8@77\"},{\"id\":9,\"name\":\"USER-9\",\"email\":\"user9@gmail.com\",\"password\":\"USER-9@77\"},{\"id\":10,\"name\":\"USER-10\",\"email\":\"user10@gmail.com\",\"password\":\"USER-10@77\"}]";

        /**
         *  org.json provide JSONObject and JSONArray classes
         */

        User user= new User(1L,"John","john@gmail.com","john@2234");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",user.getId());
        jsonObject.put("name",user.getName());
        jsonObject.put("email",user.getEmail());
        jsonObject.put("password",user.getPassword());

        String jsonString = jsonObject.toString();
        System.out.println("-------------***********---------------");
        System.out.println(jsonString);


        JSONObject jsonObject1= new JSONObject(jsonString);
        User user1= new User();
        user1.setId(jsonObject1.getLong("id"));
        user1.setName(jsonObject1.getString("name"));
        user1.setEmail(jsonObject1.getString("email"));
        user1.setPassword(jsonObject1.getString("password"));

        System.out.println(user1);
        System.out.println("-------------***********---------------");

        /**
         * JSONArray is array of JSONObject
         * getJSONObject(int index) -> method to get JSONObject from JSONArray
         */

        JSONArray jsonArray=new JSONArray(jsonStringArray);

        List<User> userList =new ArrayList<>();
        jsonArray.forEach(i->{
//            The issue with your code is that the forEach method treats each item in the JSONArray as an Object, not a JSONObject.

            JSONObject object=(JSONObject) i;

            User u= new User();
            u.setId(object.getLong("id"));
            u.setName(object.getString("name"));
            u.setEmail(object.getString("email"));
            u.setPassword(object.getString("password"));

            userList.add(u);

            System.out.println(u);
        });

        System.out.println("-------------***********---------------");

//        will not convert to proper string, res -> {"empty":false}
//        JSONObject jsonObject2=new JSONObject(userList);

        JSONArray jsonArray1 = new JSONArray(userList);

        String jsonArray1String =  jsonArray1.toString();
        System.out.println(jsonArray1String);

        System.out.println("-------------***********---------------");


        /**
         * If  string contains {"data":[{},{}}]}
         * then we retrieve JSONObject first then use getJSONArray("FieldName") method
         */
//        JSONObject root = new JSONObject(result);
//        JSONArray data = root.getJSONArray("data");




//        // Create a list of Employee objects
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(24434, "John", 26));
//        employees.add(new Employee(24435, "Jane", 28));
//
//        // Convert list of Employee objects to a JSON array string
//        JSONArray jsonArray = new JSONArray();
//        for (Employee emp : employees) {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("id", emp.getId());
//            jsonObject.put("name", emp.getName());
//            jsonObject.put("age", emp.getAge());
//            jsonArray.put(jsonObject);
//        }
//        String jsonString = jsonArray.toString();
//        System.out.println("JSON String: " + jsonString);
//
//        // Parse JSON array string back to a list of Employee objects
//        List<Employee> parsedEmployees = new ArrayList<>();
//        JSONArray parsedArray = new JSONArray(jsonString);
//        for (int i = 0; i < parsedArray.length(); i++) {
//            JSONObject jsonObject = parsedArray.getJSONObject(i);
//            Employee emp = new Employee();
//            emp.setId(jsonObject.getInt("id"));
//            emp.setName(jsonObject.getString("name"));
//            emp.setAge(jsonObject.getInt("age"));
//            parsedEmployees.add(emp);
//        }
//
//        // Print each employee's details
//        parsedEmployees.forEach(employee -> {
//            System.out.println("Emp name: " + employee.getName() + ", Emp age: " + employee.getAge());
//            System.out.println(employee);
//        });

    }
}


