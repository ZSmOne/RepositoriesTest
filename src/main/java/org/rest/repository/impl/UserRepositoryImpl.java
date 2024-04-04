package org.rest.repository.impl;

import org.rest.db.ConnectionManager;
import org.rest.db.ConnectiontManagerImpl;
import org.rest.repository.CityRepository;

//public class UserRepositoryImpl implements UserRepository {
public class UserRepositoryImpl {

    private static final String SAVE_SQL = """
            INSERT INTO users (name, city_id)
            VALUES (?, ?) ;
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM cities
            WHERE user_id = ?
            LIMIT 1;
            """;
    private static final String UPDATE_SQL = """
            UPDATE users
            SET user_name = ?,
                city_id =?
            WHERE user_id = ?  ;
            """;
    private static final String DELETE_SQL = """
            DELETE FROM users
            WHERE user_id = ? ;
            """;
    private static final String FIND_ALL_SQL = """
            SELECT * FROM users;
            """;
    private static final String EXIST_BY_ID_SQL = """
                SELECT exists (
                SELECT 1
                    FROM users
                        WHERE user_id = ?
                        LIMIT 1);
            """;
    private static UserRepositoryImpl instance;
    private final ConnectionManager connectionManager = ConnectiontManagerImpl.getInstance();
    private final UserToBankRepositoryImpl userToBankRepository = UserToBankRepositoryImpl.getInstance();
    private final CityRepository cityRepository = CityRepositoryImpl.getInstance();
    private final BankRepositoryImpl bankRepository = BankRepositoryImpl.getInstance();

    private UserRepositoryImpl() {
    }

    public static synchronized UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }


}
