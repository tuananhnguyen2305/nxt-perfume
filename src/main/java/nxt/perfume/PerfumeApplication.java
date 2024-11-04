package nxt.perfume;

import nxt.perfume.constants.RoleConst;
import nxt.perfume.entity.Account;
import nxt.perfume.socket.SocketIORegistrar;
import nxt.perfume.socket.SocketIOServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class PerfumeApplication implements CommandLineRunner {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PerfumeApplication.class, args);


		SocketIOServerConfig serverConfig = new SocketIOServerConfig("0.0.0.0",
				"8089",
				"/ws");
		serverConfig.start();
	}

	@Override
	public void run(String... args) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is("admin"));

		Account account = mongoTemplate.findOne(query, Account.class);

		if (account != null) {
			return;
		}
		account = new Account();
		account.setUsername("admin");
		account.setPassword("admin");
		account.setRole(RoleConst.ADMIN);

		mongoTemplate.insert(account);
	}
}
