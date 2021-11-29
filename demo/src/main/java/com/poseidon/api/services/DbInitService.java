//package com.poseidon.api.services;
//
//import com.poseidon.api.demo.DemoApplication;
//import com.poseidon.api.domain.BidList;
//import com.poseidon.api.domain.User;
//import com.poseidon.api.repositories.BidListRepository;
//import com.poseidon.api.repositories.UserRepository;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DbInitService implements CommandLineRunner {
//    private static final Logger logger = LogManager.getLogger(DemoApplication.class);
//    private UserRepository userRepository;
//    private BidListRepository bidListRepository;
//
//    public DbInitService(BidListRepository bidListRepository) {
//        this.bidListRepository = bidListRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User("u0", "123", "user0", "USER");
//        this.userRepository.save(user);
//        BidList bid = new BidList("account0", "type0", 10.0);
//        this.bidListRepository.save(bid);
//        logger.info("dbInitTest");
//    }
//
//}
