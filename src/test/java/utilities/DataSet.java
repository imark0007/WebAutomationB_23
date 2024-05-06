package utilities;

import org.testng.annotations.DataProvider;


public class DataSet {

    @DataProvider(name ="invalidCredentials" )
    public static Object invalidLoginData(){
        Object [] [] data = {{"jiwom54235@rehezb.com","112233445566778899","Your email or password is incorrect"},
                {"jiwom54235@re.com","112233445566",""},
                {"jiwom54235@rehezb.com","",""},
                {"","112233445566",""},
                {"","",""},
                {"jiwom54235@re.com","112233445566778899","Your email or password is incorrect"}
        };
        return data;
    }
}