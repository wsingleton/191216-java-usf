package com.revature.repos;

import com.revature.models.Account;
import com.revature.models.AccountUser;
import com.revature.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;

public class AccountUserRepository implements CrudRepository<AccountUser> {

    @Override
    public void save(AccountUser newObj) throws SQLException {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "INSERT INTO bank_app.accounts_users VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newObj.getId());
            pstmt.setInt(2, (int) newObj.getAccountId());

        }
    }

    @Override
    public Set<AccountUser> findAll() {
        return null;
    }

    @Override
    public Optional<AccountUser> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Boolean update(AccountUser updatedObj) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
