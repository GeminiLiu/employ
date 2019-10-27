package com.jagt.employ.common.generator;

import com.jagt.employ.common.tools.Snowflake_;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class SnowflakeGenerator extends IdentityGenerator {
    private final static Snowflake_ snowflake = new Snowflake_();
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        Object id = snowflake.nextId();
        if(id != null){
            return (Serializable) id;
        }
        return super.generate(session, object);
    }

    private static long getWorkerId() {
        InetAddress address;
        try {
            address = InetAddress.getLocalHost();
        } catch (final UnknownHostException e) {
            throw new IllegalStateException("Cannot get LocalHost InetAddress, please check your network!");
        }
        byte[] ipAddressByteArray = address.getAddress();
        long workerId = 0L;
        // IPV4
        if (ipAddressByteArray.length == 4) {
            for (int i = 2; i < 4 ; i++) {
                workerId += ipAddressByteArray[i] & 0xFF;
            }
        }
        // IPV6
        else if (ipAddressByteArray.length == 16) {
            for (byte byteNum : ipAddressByteArray) {
                workerId += byteNum & 0B111111;
            }
        } else {
            throw new IllegalStateException("Bad LocalHost InetAddress, please check your network!");
        }
        return workerId;
    }

}
