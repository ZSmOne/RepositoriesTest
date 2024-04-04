package org.rest.repository.impl;

import org.rest.db.ConnectionManager;
import org.rest.db.ConnectiontManagerImpl;

//public class BankRepositoryImpl implements BankRepository {
public class BankRepositoryImpl {


    private static final String SAVE_SQL = """
            INSERT INTO banks
            VALUES (?);
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM banks
            WHERE bank_id = ?
            LIMIT 1;
            """;
    private static final String FIND_ALL_SQL = """
            SELECT * FROM banks;
            """;
    private static final String UPDATE_SQL = """
            UPDATE banks
            SET bank_name = ?
            WHERE bank_id = ?;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM banks
            WHERE banks_id = ?;
            """;
    private static final String EXIST_BY_ID_SQL = """
                SELECT exists (
                SELECT 1
                    FROM banks
                        WHERE bank_id = ?
                        LIMIT 1);
            """;

    //private final UserToBankRepository userToBankRepository = UserToBankRepositoryImpl.getInstance();

    private static BankRepositoryImpl instance;
    private final ConnectionManager connectionManager = ConnectiontManagerImpl.getInstance();

    private BankRepositoryImpl() {
    }

    public static synchronized BankRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new BankRepositoryImpl();
        }
        return instance;
    }

}

