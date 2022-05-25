package simple.com;


import simple.com.presentation.ui.DisplayingInfoDB;

import java.io.IOException;
import java.sql.SQLException;

public class MainApplication {

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        new DisplayingInfoDB();

    }
}
