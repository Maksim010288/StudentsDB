package simple.com.service;

import simple.com.config.DBConfigDTO;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class StudentFoto {
    Connection dbconnection = null;

    public void inputFoto() throws IOException, SQLException {
        BufferedImage file = ImageIO.read(new File("foto/JPEG_example_down.jpg"));
        Blob blob = dbconnection.createBlob();
        try(OutputStream outputStream = blob.setBinaryStream(1)){
            ImageIO.write(file, "jpg", outputStream);
        }

        PreparedStatement preparedStatement = dbconnection.prepareStatement(
                "insert into students (foto) values (?) where id = 1");
        preparedStatement.setBlob(1, blob);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.executeQuery("select * from students");
        while (resultSet.next()) {
            BufferedImage image2 = ImageIO.read(blob.getBinaryStream());
            File newImage = new File("nova1.jpg");
            ImageIO.write(image2, "jpg", newImage);
        }
    }

}
