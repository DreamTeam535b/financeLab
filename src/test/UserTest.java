import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void Test1(){
        User user1 = new User(100,"name");
        user1.submitTransaction(50,"","");
        assertEquals(50,user1.getUserBalance());
    }
    @Test
    void Test2(){
        User user1 = new User(100,"name");
        user1.receiveTransaction(50,"","");
        assertEquals(150,user1.getUserBalance());
    }

}