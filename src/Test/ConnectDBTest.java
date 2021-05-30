package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controller.ConnectDB;

class ConnectDBTest {

	Connection connection;
	
	@Test
	@DisplayName("Kiểm tra connect thành công")
	void testConnectDBSuccess() {
		connection = ConnectDB.connection();
		assertNotNull(connection);
	}

}
