package com.dzqc.campus.util;

import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.type.StandardBasicTypes;

import java.sql.Types;

public class MyOracleDialect  extends Oracle10gDialect {
    public MyOracleDialect() {
        super();
        registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());


    }
}