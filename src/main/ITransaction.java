import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.Date;

public interface ITransaction {
    public double getAmount();
    public Date getDate();
    public String getDescription();
    public String getSource();
    public String getDestination(); // Додали новий метод для отримання стану транзакції
}

