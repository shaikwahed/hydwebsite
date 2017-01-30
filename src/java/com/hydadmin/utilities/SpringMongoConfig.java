package com.hydadmin.utilities;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abdurrahman
 */
@Configuration
public class SpringMongoConfig {

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
//        MongoClient mongo = new MongoClient("localhost");
//        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongo, "hmp");
        MongoClient mongo = new MongoClient("198.15.127.150");
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongo, "hmp");
//        MongoClient mongo = new MongoClient("128.199.64.31");
//        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongo, "truckguru");
        return simpleMongoDbFactory;

    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        // show error, should off on production to speed up performance
        mongoTemplate.setWriteConcern(WriteConcern.SAFE);

        return mongoTemplate;

    }
}
