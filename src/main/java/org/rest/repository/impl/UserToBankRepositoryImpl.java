package org.rest.repository.impl;

import org.rest.db.ConnectionManager;
import org.rest.db.ConnectiontManagerImpl;


//public class UserToBankRepositoryImpl implements UserToBankRepository {
public class UserToBankRepositoryImpl {
    private static final String SAVE_SQL = """
            INSERT INTO users_banks (user_id, bank_id)
            VALUES (?, ?);
            """;
    private static final String UPDATE_SQL = """
            UPDATE users_banks
            SET user_id = ?,
                bank_id = ?
            WHERE users_banks_id = ?;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM users_banks
            WHERE users_banks_id = ? ;
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM users_banks
            WHERE users_banks_id = ?
            LIMIT 1;
            """;
    private static final String FIND_ALL_SQL = """
            SELECT * FROM users_banks;
            """;
    private static final String FIND_ALL_BY_USER_ID_SQL = """
            SELECT * FROM users_banks
            WHERE user_id = ?;
            """;
    private static final String FIND_ALL_BY_BANK_ID_SQL = """
            SELECT * FROM users_banks
            WHERE bank_id = ?;
            """;
    private static final String FIND_BY_USERID_AND_BANK_ID_SQL = """
            SELECT * FROM users_banks
            WHERE user_id = ? AND bank_id = ?
            LIMIT 1;
            """;
    private static final String DELETE_BY_USER_ID_SQL = """
            DELETE FROM users_banks
            WHERE user_id = ?;
            """;
    private static final String DELETE_BY_BANK_ID_SQL = """
            DELETE FROM users_banks
            WHERE bank_id = ?;
            """;
    private static final String EXIST_BY_ID_SQL = """
                SELECT exists (
                SELECT 1
                    FROM users_banks
                        WHERE users_banks_id = ?
                        LIMIT 1);
            """;
    private final ConnectionManager connectionManager = ConnectiontManagerImpl.getInstance();
    private final BankRepositoryImpl bankRepository = BankRepositoryImpl.getInstance();
    private final UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();
    private static UserToBankRepositoryImpl instance;


    private UserToBankRepositoryImpl() {
    }

    public static synchronized UserToBankRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserToBankRepositoryImpl();
        }
        return instance;
    }


}
